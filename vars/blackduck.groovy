#!/usr/bin/env groovy

def scanImage(blackduck_ProjectName, blackduck_Version, blackduck_scanName, imageName) {
    synopsys_detect detectProperties: """--detect.project.name=${blackduck_ProjectName} 
    --detect.project.version.name=${blackduck_Version} 
    --detect.code.location.name=${blackduck_scanName} 
    --detect.target.type=IMAGE 
    --detect.docker.image=${imageName} 
    --detect.tools.excluded=BINARY_SCAN""", downloadStrategyOverride: [$class: 'ScriptOrJarDownloadStrategy']
}

def scanSource(blackduck_ProjectName, blackduck_Version, blackduck_scanName, blackduck_sourcePath) {
    synopsys_detect detectProperties: """--detect.project.name=${blackduck_ProjectName} 
    --detect.project.version.name=${blackduck_Version} 
    --detect.code.location.name=${blackduck_scanName} 
    --detect.source.path=${blackduck_sourcePath}
    --detect.target.type=SOURCE
    --detect.blackduck.signature.scanner.snippet.matching=FULL_SNIPPET_MATCHING
    --detect.blackduck.signature.scanner.individual.file.matching=SOURCE
    --detect.blackduck.signature.scanner.upload.source.mode=true 
    --detect.tools.excluded=BINARY_SCAN""", downloadStrategyOverride: [$class: 'ScriptOrJarDownloadStrategy']
}
