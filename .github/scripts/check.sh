#!/bin/bash
#
# Check file naming convention of challenges.
#
# Usage:
#     check.sh May-LeetCoding-Challenge
#
cd "$(dirname ${BASH_SOURCE})"/../..

challenge_dir="${PWD}/${1}"
errors=0

echo "Checking ${challenge_dir}"
echo

for question_path in $challenge_dir/*
do
    dirname="${question_path##*/}"  # remove parent directoris
    question="${dirname#*-}"        # remove leading day prefix
    echo "Question ${dirname}:"

    for filepath in $question_path/*
    do
        filename="${filepath##*/}"
        if [[ "${filename%.*}" == "$question" || "$filename" == "README.md" ]]
        then
            echo "  PASSED: ${filename}"
        else
            echo "  FAILED: ${filename}"
            errors=$((errors + 1))
        fi
    done
    echo
done

if [ "$errors" -gt 0 ]
then
    cat << EOF
Check failed with ${errors} errors detected. Please check the console
output above and follow naming convention:

    \${question}.\${language}

EOF
    exit 1
fi
