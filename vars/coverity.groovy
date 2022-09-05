#!/usr/bin/env groovy

def capture(projectName, streamName) {
    withCoverityEnvironment(coverityInstanceUrl: 'http://10.103.3.36:8080', createMissingProjectsAndStreams: true, projectName: "${projectName}", streamName: "${streamName}", viewName: 'High Impact Outstanding') {
        sh """
            cov-configure --python
            cov-capture --dir idir --source-dir %pwd%
            cov-analyze --dir idir --all --webapp-security --distrust-all --strip-path %pwd%
            cov-commit-defects --dir idir --url $COV_URL --stream $COV_STREAM
        """
    }
}

def build() {
}