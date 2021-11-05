package sap;

import javax.xml.XMLConstants;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class TransformerFactoryTest {
	private String prettyFormatXML(String xmlBuffer){
		String xmlString;
		try{
			TransformerFactory factory = TransformerFactory.newInstance();

			factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
			factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
//            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
//            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			//initialize StreamResult with File object to save to file
			StreamResult result = new StreamResult(new StringWriter());
			Source source = new StreamSource(new StringReader(xmlBuffer));
			transformer.transform(source, result);
			xmlString = result.getWriter().toString();
		}catch(IllegalArgumentException | TransformerFactoryConfigurationError | TransformerException e){
			//Replace with logger
			e.printStackTrace();
			return xmlBuffer;
		}
		return xmlString;
	}

	public static void main(String[] args){
		TransformerFactoryTest t = new TransformerFactoryTest();
		String s = t.prettyFormatXML("<upgrade-feature feature_id=\"DRTM_ONBOARDING\" module-ref-id=\"PLATFORM\"\n" +
			"                     perm-check=\"[admin|general_admin] or [sys_admin|company_system_and_logo_sys_admin] or [admin|sys_admin]\"\n" +
			"                     edition=\"[true]\"\n" +
			"                     feature-name=\"UPGRADECENTER_DRTM_ONBOARDING_NAME\"\n" +
			"                     feature-desc=\"UPGRADECENTER_DRTM_ONBOARDING_DESC\">\n" +
			"      <availability-handler>\n" +
			"        <availability-processor class-name=\"ONBDRTMUpgradeAvailableCheck\"/>\n" +
			"      </availability-handler>\n" +
			"      <about-info feature-intro=\"UPGRADECENTER_DRTM_ONBOARDING_INTRO\">\n" +
			"        <multimedia-content >\n" +
			"          <media-server isIncluded=\"true\" />\n" +
			"        </multimedia-content>\n" +
			"      </about-info>\n" +
			"      <category-evaluation>\n" +
			"        <category-type value=\"OPTIONAL\"/>\n" +
			"      </category-evaluation>\n" +
			"      <upgrade-type>\n" +
			"        <auto async=\"false\" upgrade-time-mins='0' require-logout=\"false\" >\n" +
			"          <action-handler>\n" +
			"            <action-processor upgrade-class-name=\"ONBDRTMUpgradeActionProcessor\" />\n" +
			"          </action-handler>\n" +
			"        </auto>\n" +
			"      </upgrade-type>\n" +
			"    </upgrade-feature>");
		System.out.println(s);
	}
}
