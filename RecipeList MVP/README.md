# Recipe List MVP

Recipe List APP using MVP architecture to list all recipe from json file and click this will auto open web page.

# WHAT I LEARN IN THIS APP:
When link to webpage it pop up "ERR_CLEARTEXT_NOT_PERMITTED".
Cause in Android 9.0 will block Apps from sending internet traffic that anyone can see.
To prevent from this it needs to use TLS(Transport Layer Security) to secure data.
Therefore, adding `android:usesCleartextTraffic="true"` in `AndroidMainifest.xml`
Also,we could create a xml file call `@xml/network_security_config`

`<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        ....
        ....
    </domain-config>
    <base-config cleartextTrafficPermitted="false"/>
</network-security-config> `

And adding this in AndroidMainifest.xml like `android:networkSecurityConfig="@xml/network_security_config"`