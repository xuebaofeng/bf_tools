package sap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SPMetaDataGen {

	public static void main(String[] args) throws IOException{
		String domain = "hcm23dr.sapsf.com";
		Stream<String> lines = Files.lines(Paths.get("C:/wbem/github/trunk/au-V4/au-V4-service/src/main/resources/dataCenterSAML2EntityIDMap.properties"));
		String prod_certificate = lines.filter(
			l -> l.startsWith("prod_certificate")
		).map(l -> {
			String[] split = l.split("\\|");
			l = split[1];
			return l;
		}).collect(Collectors.joining());

		String xml = "<md:EntityDescriptor xmlns:md=\"urn:oasis:names:tc:SAML:2.0:metadata\" validUntil=\"2016-10-23T09:41:00Z\" cacheDuration=\"PT604800S\" entityID=\"https://{0}\">\n" +
			"  <md:SPSSODescriptor AuthnRequestsSigned=\"true\" WantAssertionsSigned=\"false\" protocolSupportEnumeration=\"urn:oasis:names:tc:SAML:2.0:protocol\">\n" +
			"    <md:KeyDescriptor use=\"signing\">\n" +
			"      <ds:KeyInfo xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
			"        <ds:X509Data>\n" +
			"          <ds:X509Certificate>{1}</ds:X509Certificate>\n" +
			"        </ds:X509Data>\n" +
			"      </ds:KeyInfo>\n" +
			"    </md:KeyDescriptor>\n" +
			"    <md:KeyDescriptor use=\"encryption\">\n" +
			"      <ds:KeyInfo xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
			"        <ds:X509Data>\n" +
			"          <ds:X509Certificate>{2}</ds:X509Certificate>\n" +
			"        </ds:X509Data>\n" +
			"      </ds:KeyInfo>\n" +
			"    </md:KeyDescriptor>\n" +
			"    <md:SingleLogoutService Binding=\"urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Redirect\" Location=\"https://{3}/sfsaml2/LogoutServiceHTTPRedirectResponse\"/>\n" +
			"    <md:NameIDFormat>urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified</md:NameIDFormat>\n" +
			"    <md:AssertionConsumerService Binding=\"urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST\" Location=\"https://{4}/sfsaml2/SAMLAssertionConsumer\" index=\"1\"/>\n" +
			"  </md:SPSSODescriptor>\n" +
			"</md:EntityDescriptor>";
		xml = MessageFormat.format(xml, domain, prod_certificate, prod_certificate, domain, domain);
		String path = domain + ".xml";
		Files.write(Paths.get(path), xml.getBytes());
	}
}
