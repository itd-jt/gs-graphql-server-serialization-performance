#!/bin/bash

declare -a bookCounts=("100" "1000" "10000" "100000" "500000")

for nrOfBooks in "${bookCounts[@]}"; do
  ./measure_curl_gql.sh $nrOfBooks
  ./measure_curl_json.sh $nrOfBooks
done

