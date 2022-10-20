#!/usr/bin/env groovy

def scanImage(blackduck_URL, blackduck_Token, blackduck_ProjectName, blackduck_Version, blackduck_scanName, imageName) {
    synopsys_detect detectProperties: '''--blackduck.url=${blackduck_URL} \\
    --blackduck.api.token="${blackduck_Token}" \\
    --detect.project.name=${blackduck_ProjectName} \\
    --detect.project.version.name=${blackduck_Version} \\
    --detect.code.location.name=${blackduck_scanName} \\
    --detect.target.type=IMAGE \\
    --detect.docker.image=${imageName} \\
    --detect.tools.excluded=BINARY_SCAN''', downloadStrategyOverride: [$class: 'ScriptOrJarDownloadStrategy']
}

def scanSource(blackduck_URL, blackduck_Token, blackduck_ProjectName, blackduck_Version, blackduck_scanName, blackduck_sourcePath) {
    synopsys_detect detectProperties: """--blackduck.url=${blackduck_URL} \\
    --blackduck.api.token="${blackduck_Token}" \\
    --detect.project.name=${blackduck_ProjectName} \\
    --detect.project.version.name=${blackduck_Version} \\
    --detect.code.location.name=${blackduck_scanName} \\
    --detect.source.path=${blackduck_sourcePath} \\
    --detect.tools.excluded=BINARY_SCAN""", downloadStrategyOverride: [$class: 'ScriptOrJarDownloadStrategy']
}