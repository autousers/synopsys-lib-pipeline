#!/usr/bin/env groovy

def capture(coverityURL, projectName, streamName, sourcePath) {
    withCoverityEnvironment(coverityInstanceUrl: "${coverityURL}", createMissingProjectsAndStreams: true, projectName: "${projectName}", streamName: "${streamName}", viewName: 'High Impact Outstanding') {
        sh """
            cov-capture --dir idir --source-dir ${sourcePath}
            cov-analyze --dir idir --all --webapp-security --distrust-all --strip-path ${sourcePath}
            cov-commit-defects --dir idir --url $COV_URL --stream $COV_STREAM
        """
    }
}

def build() {
}