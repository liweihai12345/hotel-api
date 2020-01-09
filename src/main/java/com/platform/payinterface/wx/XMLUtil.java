package com.platform.payinterface.wx;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
public class XMLUtil {


    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     *
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map<String, String> doXMLParse(String strxml) throws JDOMException, IOException {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

        if (null == strxml || "".equals(strxml)) {
            return null;
        }
        Map<String, String> m = new HashMap<String, String>();
        SAXBuilder builder = new SAXBuilder();
        String FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
        builder.setFeature(FEATURE, true);
        FEATURE = "http://xml.org/sax/features/external-general-entities";
        builder.setFeature(FEATURE, false);
        FEATURE = "http://xml.org/sax/features/external-parameter-entities";
        builder.setFeature(FEATURE, false);
        FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
        builder.setFeature(FEATURE, false);
        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List<?> list = root.getChildren();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List<?> children = e.getChildren();
            if (children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = XMLUtil.getChildrenText(children);
            }

            m.put(k, v);
        }

        //关闭流
        in.close();
        return m;
    }

    /**
     * 获取子结点的xml
     *
     * @param children
     * @return String
     */
    public static String getChildrenText(List<?> children) {
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()) {
            Iterator<?> it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List<?> list = e.getChildren();
                sb.append("<" + name + ">");
                if (!list.isEmpty()) {
                    sb.append(XMLUtil.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }
        return sb.toString();
    }


    /**
     * 构建请求微信的xml格式 数据
     *
     * @param params NameValuePair list集合
     * @return
     */
    public static String toXml(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        for (int i = 0; i < params.size(); i++) {
            sb.append("<" + params.get(i).getName() + ">");

            sb.append(params.get(i).getValue());
            sb.append("</" + params.get(i).getName() + ">");
        }
        sb.append("</xml>");

        return sb.toString();
    }

    /**
     * 获取xml编码字符集
     *
     * @return
     * @throws IOException
     * @throws JDOMException
     */
	/*   public static String getXMLEncoding(String strxml) throws JDOMException, IOException {
	      InputStream in = HttpClientUtil.String2Inputstream(strxml);
	      SAXBuilder builder = new SAXBuilder();
	      Document doc = builder.build(in);
	      in.close();
	      return (String)doc.getProperty("encoding");
	   }*/
    public static String returnFailXML(String msg) {

        return "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA["+msg+"]]></return_msg></xml>";
    }
    public static String returnSuccessXML() {

        return "<xml><return_code><![CDATA[SUCCESS ]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    }

    /**
     * 解析 xml 此方法可能没有UTF-8解析是的转码
     *
     * @param content xml格式文本
     * @return map 对象
     */
    public static Map<String, String> decodeXml(String content) {

        try {
            Map<String, String> xml = new HashMap<String, String>();
            // 获得pull解析器工厂
            XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();

            XmlPullParser parser = pullParserFactory.newPullParser();
            parser.setInput(new StringReader(content));
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {

                String nodeName = parser.getName();
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:

                        if ("xml".equals(nodeName) == false) {
                            // 实例化student对象
                            xml.put(nodeName, parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                event = parser.next();
            }
            return xml;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
