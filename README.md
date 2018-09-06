# TOTP Connector for Mule 4
Used to generate a time based, one time use token that is compatible with the Google Authenticator Application and similar applications.

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

Then use the **validate** operation in the flow where token validation is to be done. For example:

```
	<totp:validate doc:name="Validate edit_token" key="'${totp.ping.put}"
		inbound_totp="#[attributes.headers['${totp.property}']]" enabled="${totp.enabled}" />
```

A totp token can be generated using the **generate** operation. The token will be returned in the payload.

Use **enabled** set to false if you wish to skip the token validate.

**key** is required parameter value. It is the same key entered into the Google Authenicator application on you mobile device.

**totpPropertyName** will default to "edit_token".
