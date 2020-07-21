#!groovy

import digital.alonso.jenkins.pipeline.lib.NetworkUtils

/**
 * Returns first available port.
 * Params:
 *   - first: Optional. First port in range . Defaults to 1
 *   - last: Optional. Last port in range. Defaults to 65535
 */

def call(Map range = [:]) {
    return NetworkUtils.getFirstAvailablePort(range);
}