# Information-Systems-Architecture-Project
Social Network using LDAP and synchronisation for schools

## API structure

|     Verbe HTTP          |Endpoint |Action
-------------|--------------------|------------------------         
|POST|    /school   |Add a new school in DB with the json as datas   |

## Database Structure

- users with the users
- school_keys with each school_key. Cyphering with the salt : "archibook", and hashing with sha256

## Test

```
curl -X POST -H "Accept: application/json" -d '{"name"="Francois"}' http://website/api.php/school
```

Exemple of json datas :

```
{
	'1':{
		'name':'John',
		'password':'mypassword'
	},
	'2':{
		'name':'Henry',
		'password':'mypassword2'
	},
}
```
