# Information-Systems-Architecture-Project
Social Network using LDAP and synchronisation for schools

## API structure

|     Verbe HTTP          |Endpoint |Action
-------------|--------------------|------------------------         
|POST|    /API_key   |Confirm that you are a registered school. |

*Contact ours folks to obtain an API key.*

## Database Structure

- users with the users
- school_keys with each school_key. Cyphering with the salt : "archibook", and hashing with sha256

## Test

```
curl -X POST -H "Accept: application/json" -d '{"1":{"name":"test","password":"123","mail
":"test@test.com"}}' http://website/api.php/api_school
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
