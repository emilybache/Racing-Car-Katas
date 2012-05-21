(function ($) {
	if ($.a) { throw 'the "a" namespace already exists'; }
	if ($.any) { throw 'the "any" namespace already exists'; }
	$.a = {};
	$.any = {};

	$.a.fake = function (blueprint) {
		return new $.a.Fake(blueprint);
	};
	$.a.Fake = function (blueprint) {
		var createInterceptedMethod = function () {
			var noop = function () { };
			var method = function () {
				method.numberOfCalls++;
				return method.behavior.apply(this, arguments);
			};
			method.numberOfCalls = 0;
			method.behavior = noop;
			method.whenCalled = function (newBehavior) { method.behavior = newBehavior; };
			return method;
		};
		
		_interceptMethodsFor.call(this, blueprint.prototype, createInterceptedMethod);
		_interceptMethodsFor.call(this, blueprint, createInterceptedMethod);
	};

	$.a.stub = function (blueprint) {
		return new $.a.Stub(blueprint);
	};
	$.a.Stub = function (blueprint) {
		var createNoopMethod = function () {
			return function () { };
		};

		_interceptMethodsFor.call(this, blueprint.prototype, createNoopMethod);
		_interceptMethodsFor.call(this, blueprint, createNoopMethod);
	};

	$.a.mock = function (blueprint) {
		return new $.a.Mock(blueprint);
	};
	$.a.Mock = function (blueprint) {
		createUnexpectedCallMethod = function (methodName) {
			return function () { throw "call to '" + methodName + "' not expected"; };
		};

		_interceptMethodsFor.call(this, blueprint.prototype, createUnexpectedCallMethod);
		_interceptMethodsFor.call(this, blueprint, createUnexpectedCallMethod);
	};

	$.any.callTo = function (fake) {
		return {
			_fake: fake,
			willThrow: function () {
				var unexpected = function () { throw 'unexpected call'; };
				for (var methodName in this._fake) {
					this._fake[methodName].behavior = unexpected;
				}
				return this._fake;
			}
		};
	};

	var _interceptMethodsFor = function (obj, createInterceptedMethodFunc) {
		for (var methodName in obj) {
			var isFunction = obj[methodName] instanceof Function;
			var isPublic = methodName[0] !== '_';
			if (isFunction && isPublic) {
				this[methodName] = createInterceptedMethodFunc(methodName);
			}
		}
	};

})(this);
