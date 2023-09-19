#!/bin/bash

nrOfBooks=$1
echo "Measuring performance..."
echo "Result mode: GQL"
echo "Nr of books: $nrOfBooks"

curl -s -w "@curl-format" -d "{\"query\":\"query x { allBooks(nrOfBooks: $nrOfBooks) { id name pageCount author { id firstName lastName } } }\"}" -v http://localhost:8080/graphql -H "Content-Type: application/json" -o ./gql_output 2> /dev/null
