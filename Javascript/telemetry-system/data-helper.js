
class DataHelper {

    _connectionEventsSimulator (min, max) {
        var delta = max + 1 - min;
        return min + Math.floor(delta * Math.random());
    }

}

module.exports = DataHelper