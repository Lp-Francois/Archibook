# Information-Systems-Architecture-Project
Social Network using LDAP and synchronisation for schools

## API structure

|     Verbe HTTP          |Endpoint |Action
-------------|--------------------|------------------------         
|POST|    /school   |Add a new school in DB with the json as datas   |

## Test

```
curl -X POST -H "Accept: application/json" -d '{"name"="Francois"}' http://website/api.php/school
```
