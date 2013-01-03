# GitHub Counter

GitHub Counter is command-line utility to count your github account metrics.
It counts your followers, following, public repos and public gists.

## Usage

    $ cd github-counter
    $ cat <<EOT >resources/github-counter.properties
    # output file path
    filename=/home/user/github-counter/github-counter.txt
    # target user name
    username=bouzuya
    EOT
    $ lein uberjar
    $ java -jar target/github-counter-0.1.0-standalone.jar
    $ cat github-counter.txt
    2013-01-03,5,24,23,35

Output file format is CSV. It has following columns.

    DATE,FOLLOWERS,FOLLOWING,PUBLIC-REPOS,PUBLIC-GISTS

## License

Copyright © 2013 bouzuya

Distributed under the Eclipse Public License, the same as Clojure.
