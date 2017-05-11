# ElementsVibrateServer

##### Description

Perceptions Elements Vibrating in webapps.

##### Enviroment

The ElementsVibrateServer is a JEE application running in WebSphere Liberty.

##### Configuration

Download the ElementsVibrateServer project

`git clone https://github.com/guilhermeogliari/ElementsVibrateServer/`

##### JSON input

Send POST action to:

`http:// < Server Location > /ElementsVibrateServer/api/InputVibrate/`

Exemple input:

```json
{
	"duration":2,
	"intensity":100,
	"interval":2,
	"repeat":3
}
```
> duration, intensity in mileseconds
