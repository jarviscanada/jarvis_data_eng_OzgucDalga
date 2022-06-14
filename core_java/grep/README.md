# Introduction
 Grep application was created to learn the fundamentals of core Java. In this project, the grep app searches for a text pattern recursively in a given directory and outputs matched lines to the file. Furthermore, Docker was used to creating local image and container, all the things recorded was published in docker. hub.
# Quick Start
For Regex;
regex_pattern=".*Romeo.*Julliet.*"
 src_dir="./data"
outfile=grep_2022-06-14_17:36:30.txt
For Docker
 docker run --rm -v /home/centos/dev/jarvis_data_eng_OzgucDalga/core_java/grep/data:/data -v /home/centos/dev/jarvis_data_eng_OzgucDalga/core_java/grep/log:/log ozgucdalga/grep .*Romeo.*Juliet.* /data /log/grep.out   /out/

# Implementation
## Pseudocode
matchedLines = []
for file in listFilesRecursively(rootDir)
   for line in readLines(file)
       if containsPattern(line)
        matchedLines.add(line)
 writeToFile(matchedLines)

# Performance Issue
Based on current performance, the time complexity is O(n). It means that it is running Linear(fair). In order to get a better result, different algorithms can be implemented.
# Test
IntelliJ test runner in the console is used for the test in each method, errors  are fixed using the Debugger system
# Deployment
 The application was deployed using Docker hu, the steps are shown below;
 -Registering docker.hub
 -Created Dockerfile,
 -Java application package,
 - New local image was created,
- Published into Docker.hub
 # Improvement
 -Lambda is learned, it is useful and lesser complex than normal usage,
 -Stream API is learned to create successively process easier,
 - Maven product management was understood strongly
