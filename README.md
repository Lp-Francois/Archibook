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

## Installation sync-tool

Add all the librairies to the java project.
* With the *httpcomponents-client-4.5.5-bin*, you have to get all the jar files in the lib folder.
* With Maven, get the org.eclipse.ecf:org.apache.httpcomponents.httpclient{version}

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
