# Information-Systems-Architecture-Project
Social Network using LDAP and synchronisation for schools

## API structure

|     Verbe HTTP          |Endpoint |Action
-------------|--------------------|------------------------         
|POST|    /school   |Precise the school   |

## Test

```
curl -X POST -H "Accept: application/json" -d '{"name"="Francois"}' http://website/api.php/school
```
