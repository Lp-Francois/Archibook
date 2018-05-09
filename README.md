# Information-Systems-Architecture-Project
Social Network using LDAP and synchronisation for schools

## API structure

|     Verbe HTTP          |Endpoint |Action
-------------|--------------------|------------------------         
|POST|    /users   |Save or modify users   |
|POST| /users?role=teacher&name=jdoe |   Save or modify teacher users named jdoe |

## Test

```
curl -X POST -H "Accept: application/json" -d 'json={"name"="Francois"}' http://88.177.205.85
```
