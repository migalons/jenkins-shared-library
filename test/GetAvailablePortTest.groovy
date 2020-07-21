import org.junit.Test

class GetAvailablePortTest {

    /**
     * Use Groovy metaclass programming to add methods to the Jenkins pipeline shared library exposed class.
     * This allows for unit testing of classes that makes use of Jenkins pipeline steps, such as
     * 'sh', 'echo' or e.g. other steps available through the workflow-basic-steps-plugin
     */
//    @BeforeClass
//    static void setup() {
//        getAvailablePort.metaClass.echo {
//            println it
//            return it
//        }
//    }

    @Test
    void shouldReturnFirstAvailablePorts() {
        def varsFile = new getAvailablePort()
        def port = varsFile.call()

        assert port != null
        assert port instanceof Number
    }

    @Test
    void shouldReturnPortInRange() {
        def varsFile = new getAvailablePort()
        def port = varsFile.call(first: 100, last: 1000)

        assert port != null
        assert port instanceof Number
        assert port >= 100 && port <= 10000
    }

    @Test
    void shouldReturnPortStartingAt() {
        def varsFile = new getAvailablePort()
        def port = varsFile.call(first: 10000)

        assert port != null
        assert port >= 10000
    }

    @Test
    void shouldReleasePortAfterStatusCheck() {
        def varsFile = new getAvailablePort()
        def port1 = varsFile.call(first: 10000, last: 20000)
        def port2 = varsFile.call(first: 10000, last: 20000)
        //if port is effectively released, then second query should return same port
        assert port1 == port2
    }

}