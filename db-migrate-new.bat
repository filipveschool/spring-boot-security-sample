set YYYY=%DATE:~6,4%
set MM=%DATE:~3,2%
set DD=%DATE:~0,2%

set HH=%TIME: =0%
set HH=%HH:~0,2%
set MI=%TIME:~3,2%
set SS=%TIME:~6,2%

set DATE_TIME_STAMP=%YYYY%%MM%%DD%%HH%%MI%%SS%

echo. 2>%~dp0/src/main/resources/db/migration/V%DATE_TIME_STAMP%__%1.sql

