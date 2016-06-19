package Parsers;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*; // dom.Document внимание ! 

public class DOMpars {
	public static void main(String[] args) throws Exception {
		// создали фабрику строителей, сложный и грамосткий процесс (по реже
		// выполняйте это действие)
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// f.setValidating(false); // не делать проверку валидации
		// создали конкретного строителя документа
		DocumentBuilder db = dbf.newDocumentBuilder();
		// стооитель построил документ
		Document doc = db.parse(new File("Sweets.xml"));
		// Document - тоже является нодом, и импленментирует методы
		visit(doc, 0);
	}
	public static void visit(Node node, int level) {
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node childNode = list.item(i); // текущий нод
			process(childNode, level + 1); // обработка
			visit(childNode, level + 1); // рекурсия
		}
	}
	public static void process(Node node, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print('\t');
		}
	//	if (node.getNodeType() == Node.ELEMENT_NODE) {
			System.out.print(node.getNodeName());
			if (node.getNodeValue() != null) {
				System.out.print(" " + node.getNodeValue());
	//		}
		}
		if (node instanceof Element) {
			Element root = (Element) node;
			// работаем как с элементом (у него есть атрибуты и схема)
			if (root.hasAttributes()) {
				// get attributes names and values
				NamedNodeMap nodeMap = root.getAttributes();
				for (int i = 0; i < nodeMap.getLength(); i++) {
					Node tempNode = nodeMap.item(i);
					System.out.print(" " + '\t' + "Attr: " + tempNode.getNodeName() + " " + tempNode.getNodeValue());
				}
			}
		}
		System.out.println();
	}
}
//// Создание документа
// public static void main(String[] argv) throws Exception {
// DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
// DocumentBuilder builder = factory.newDocumentBuilder();
// DOMImplementation impl = builder.getDOMImplementation(); // более сложный, но
//// и более гибкий способ создания документов
// Document doc = impl.createDocument(null, // namespaceURI
// null, // qualifiedName
// null); // doctype
// Element e1 = doc.createElement("api");
// doc.appendChild(e1);
// Element e2 = doc.createElement("java");
// e2.setAttribute("url", "http://www.quizful.net");
// e1.appendChild(e2);
// }
// }