# TOTP Connector for Mule 4
Used to either generate or validate a time based, one time use token that is compatible with the Google Authenticator Application and similar applications.

Useful for implementing a two-factor authentication scheme.

To use this connector, define this dependency:

```
		<dependency>
			<groupId>org.mule.consulting</groupId>
			<artifactId>totp</artifactId>
			<version>1.0.2</version>
			<classifier>mule-plugin</classifier>
		</dependency>
```

Then use the **validate** operation in the flow where token validation is to be done. For example if the totp is being sent in the edit_totp header, then use:

```
	<totp:validate doc:name="Validate edit_token" key="navy cats rope base"
		inbound_totp="#[attributes.headers['edit_totp']]" enabled="true" />
```

A totp token can be generated using the **generate** operation. The token will be returned in the payload.

Use **enabled** set to false if you wish to skip the token validate.

**key** is required parameter value. It is the same key entered into the Google Authenicator application on you mobile device. It needs to be 16 characters (4 pairs of 4 characters, no digits).

**totpPropertyName** will default to "edit_token".

## Simple test of Generate/Validate

```
	<http:listener-config name="HTTP_Listener_config" doc:name="HTTP Listener config" doc:id="d785956d-8f16-40bf-ae9c-a6e577971cf8" >
		<http:listener-connection host="0.0.0.0" port="8081" />
	</http:listener-config>
	<flow name="test-mule4-totpFlow" doc:id="f34c7e2a-92c0-4e13-afa2-d3556bc383df" >
		<http:listener doc:name="Listener" doc:id="384ac7f4-09de-4332-85e1-aee442748f27" config-ref="HTTP_Listener_config" path="/test"/>
		<totp:generate doc:name="Generate" doc:id="d36d10c6-01b9-4eb6-b410-f4e2028b7307" key="navy cats rope base" />
		<totp:validate doc:name="Validate" doc:id="851447ff-0957-441f-83ba-b09e0892da02" key="navy cats rope base" inbound_totp="#[payload]" enabled="true"/>
	</flow>
```