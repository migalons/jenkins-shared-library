package digital.alonso.jenkins.pipeline.lib

class NetworkUtils {

    static int getFirstAvailablePort(Map range = [:]) throws IOException {

        if(range.first == null || !(range.first instanceof Number)) {
            range.first = Constants.PORT_RANGE_START
        }
        if(range.last == null || !(range.last instanceof Number)) {
            range.last = Constants.PORT_RANGE_END
        }
        for (int port = range.first; port < range.last; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port)
                serverSocket.close()
                return port
            } catch (IOException ex) {
                continue; // try next port
            }
        }

        // if the program gets here, no port in the range was found
        throw new IOException("no free port found");
    }

}
