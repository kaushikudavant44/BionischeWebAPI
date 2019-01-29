/*
 * This example was written by Bruno Lowagie in the context of a book.
 * See http://developers.itextpdf.com/content/zugferd-future-invoicing/5-creating-pdf-invoices-basic-profile
 */
package com.bionische.biotech.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.account.model.DoctorSuscriptionReceipt;
import com.bionische.biotech.account.model.GetDoctorConsultingReceipt;
import com.bionische.biotech.account.model.GetLabReportReceipt;
import com.bionische.biotech.account.model.GetPharmacyPrescriptionReceipt;
import com.bionische.biotech.account.model.LabSuscriptionReceipt;
import com.bionische.biotech.account.model.PharmacySuscriptionReceipt;
import com.bionische.biotech.account.repository.DoctorSuscriptionReceiptRepository;
import com.bionische.biotech.account.repository.GetDoctorConsultingReceiptRepository;
import com.bionische.biotech.account.repository.GetLabReportReceiptRepository;
import com.bionische.biotech.account.repository.GetPharmacyPrescriptionReceiptRepository;
import com.bionische.biotech.account.repository.LabSuscriptionReceiptRepository;
import com.bionische.biotech.account.repository.PharmacySuscriptionReceiptRepository;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

/**
 
 * @author Ganesh
 * 
 * 
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itextpdf</artifactId>
    <version>5.0.6</version>
</dependency>
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>layout</artifactId>
    <version>7.0.0</version>
</dependency>
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>kernel</artifactId>
    <version>7.0.0</version>
</dependency>
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>zugferd</artifactId>
    <version>2.0.1</version>
</dependency>
 */

@RestController
public class PdfInvoicesApiController {

//	String iconFile="C:\\Users\\Admin\\Desktop\\war\\logo.jpg";
//	String pdfFile="E:\\spring-tool-suite-3.9.2.RELEASE-e4.7.2-win32-x86_64\\sts-bundle\\sts-3.9.2.RELEASE\\reports\\1\\MyFirstDynamic3.pdf";
	String iconFile="/usr/local/apache-tomcat-9.0.13/webapps/bioWebApi/images/logo.jpg";
	String pdfFile="/usr/local/apache-tomcat-9.0.13/webapps/bioWebApi/images/MyFirstDynamic3.pdf";
	
	@Autowired
	DoctorSuscriptionReceiptRepository doctorSuscriptionReceiptRepository;
	@Autowired
	GetDoctorConsultingReceiptRepository getDoctorConsultingReceiptRepository;
	@Autowired
	GetLabReportReceiptRepository getLabReportReceiptRepository;
	@Autowired
	LabSuscriptionReceiptRepository labSuscriptionReceiptRepository;
	@Autowired
	PharmacySuscriptionReceiptRepository pharmacySuscriptionReceiptRepository;
	@Autowired
	GetPharmacyPrescriptionReceiptRepository getPharmacyPrescriptionReceiptRepository;

	@RequestMapping(value = { "/doctorSubscriptionReceiptPdf" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> doctorSubscriptionReceiptPdf(@RequestParam("suscriptionId") int suscriptionId)
			throws IOException {

		DoctorSuscriptionReceipt doctorSuscriptionReceipt = doctorSuscriptionReceiptRepository
				.findBySuscriptionId(suscriptionId);

		// Creating a PdfWriter object
		String dest = pdfFile;
		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		// Creating a table
		float[] pointColumnWidths = { 150F, 150F, 150F };
		Table table = new Table(pointColumnWidths);

		// Populating row 1 and adding it to the table
		Cell c1 = new Cell(); // Creating cell 1
		c1.add("Order Id"); // Adding name to cell 1
		c1.setBackgroundColor(Color.DARK_GRAY); // Setting background color
		// c1.setBorder(Border.NO_BORDER); // Setting border
		c1.setTextAlignment(TextAlignment.CENTER); // Setting text alignment
		table.addCell(c1); // Adding cell 1 to the table

		Cell c2 = new Cell();
		c2.add("Txn Id");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		// Populating row 2 and adding it to the table
		Cell c3 = new Cell();
		c3.add("Amount");
		c3.setBackgroundColor(Color.GRAY);
		// c3.setBorder(Border.NO_BORDER);
		c3.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c3);

		Cell c4 = new Cell();
		c4.add(doctorSuscriptionReceipt.getOrderId());
		// c4.setBackgroundColor(Color.WHITE);
		// c4.setBorder(Border.NO_BORDER);
		c4.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c4);

		// Populating row 3 and adding it to the table
		Cell c5 = new Cell();
		c5.add(doctorSuscriptionReceipt.getTxnId());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		Cell c6 = new Cell();
		c6.add(doctorSuscriptionReceipt.getAmount() + "");
		// c6.setBackgroundColor(Color.GRAY);
		// c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(doctorSuscriptionReceipt.getAmount() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		/*
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add(" "); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell();
		 * 
		 * c6.setTextAlignment(TextAlignment.CENTER); c6.setBorder(Border.NO_BORDER);
		 * table.addCell(c6);
		 * 
		 * c6 = new Cell();
		 * 
		 * c6.setTextAlignment(TextAlignment.CENTER); c6.setBorder(Border.NO_BORDER);
		 * table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add("Sub Total");
		 * c6.setTextAlignment(TextAlignment.CENTER); c6.setBorder(Border.NO_BORDER);
		 * table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add("1000.0"); c6.setBorder(Border.NO_BORDER);
		 * c6.setTextAlignment(TextAlignment.CENTER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add(" "); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * 
		 * 
		 * c6 = new Cell(); c6.add("Grand Total");
		 * c6.setTextAlignment(TextAlignment.CENTER); c6.setBorder(Border.NO_BORDER);
		 * table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add("1000.0"); c6.setBorder(Border.NO_BORDER);
		 * c6.setTextAlignment(TextAlignment.CENTER); table.addCell(c6);
		 */

		Text text1 = new Text(doctorSuscriptionReceipt.getAddress() + "\n" + doctorSuscriptionReceipt.getContactNo1()
				+ "\n" + doctorSuscriptionReceipt.getEmail() + "\nGSTN : "
				+ doctorSuscriptionReceipt.getCompanyGstNo());

		Text text2 = new Text(doctorSuscriptionReceipt.getCompanyName() + "\n");

		// Setting font of the text
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		PdfFont font1 = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		text1.setFont(font1);

		// Setting font color
		text1.setFontColor(Color.BLACK);
		text2.setFontSize(15);
		text1.setFontSize(11);
		text2.setFont(font);

		String imFile = iconFile;
		ImageData data = ImageDataFactory.create(imFile);

		// Creating an Image object
		Image image = new Image(data);

		// Adding image to the document
		doc.add(image);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.setWidth(200);
		paragraph1.setRelativePosition(370, -40, 0, 0);
		paragraph1.add(text2);
		paragraph1.add(text1);
		doc.add(paragraph1);

		PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());

		// Initial point of the line
		canvas.moveTo(10, 680);

		// Drawing the line
		canvas.lineTo(585, 680);

		// Closing the path stroke
		canvas.closePathStroke();

		// table.setFixedPosition(10, 720, 585);

		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		Text invoceTo = new Text("INVOICE TO,\n");
		Text invoceToDetails = new Text(
				doctorSuscriptionReceipt.getDoctorName() + "\nGSTN :- " + doctorSuscriptionReceipt.getGstNo());
		Paragraph paragraphInvoceTo = new Paragraph();
		invoceTo.setFont(font);
		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		invoceToDetails.setFont(font);
		invoceToDetails.setFontSize(11);
		invoceToDetails.setFontColor(Color.BLACK);

		// invoceToDetails.setFontSize(11);

		paragraphInvoceTo.add(invoceTo);
		paragraphInvoceTo.add(invoceToDetails);
		paragraphInvoceTo.setRelativePosition(20, -10, 0, 0);
		doc.add(paragraphInvoceTo);

		Paragraph paragraphInvoceNoAndDate = new Paragraph();

		Text invoceNo = new Text("INVOICE NO : ");

		invoceNo.setFont(font);
		paragraphInvoceNoAndDate.add(invoceNo);
		invoceNo = new Text(doctorSuscriptionReceipt.getSuscriptionId() + "\n");
		paragraphInvoceNoAndDate.add(invoceNo);
		Text invoceDate = new Text("Date :- ");
		invoceDate.setFont(font);
		invoceNo.setFontSize(12);
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate = new Text(doctorSuscriptionReceipt.getCreatedDate() + "\n");
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate.setFontSize(11);

		paragraphInvoceNoAndDate.setRelativePosition(370, -80, 10, 0);
		doc.add(paragraphInvoceNoAndDate);

		Text text = new Text("Subscription Receipt\n");
		text.setFontSize(12);
		text.setFont(font);
		Paragraph paragraphText = new Paragraph();
		paragraphText.add(text);

		paragraphText.setRelativePosition(200, -30, 0, 0);
		doc.add(paragraphText);

		// Adding Table to document
		table.setRelativePosition(10, 0, 0, 10);
		doc.add(table);

		Text thankU = new Text("Thank You !!\n");
		invoceNo.setFontSize(12);
		invoceDate.setFontSize(11);
		Paragraph paragraphThankU = new Paragraph();
		paragraphThankU.add(thankU);

		paragraphThankU.setRelativePosition(0, 5, 0, 0);
		doc.add(paragraphThankU);

		/*
		 * Text subTotal = new Text("Sub Total : 1000\n"); subTotal.setFontSize(12);
		 * 
		 * Paragraph paragraphSubTotal = new Paragraph(); paragraphThankU.add(subTotal);
		 */

		/*
		 * thankU=new Text("Sub Total : 1000.0\n"); paragraphThankU= new Paragraph();
		 * paragraphThankU.add(thankU); paragraphThankU.setFixedPosition(350, 310, 200);
		 * doc.add(paragraphThankU);
		 * 
		 * 
		 * thankU=new Text("Grand Total : 1000.0\n"); paragraphThankU= new Paragraph();
		 * paragraphThankU.add(thankU); paragraphThankU.setFixedPosition(350, 280, 200);
		 * doc.add(paragraphThankU);
		 * 
		 * // Initial point of the line canvas.moveTo(300, 300);
		 * 
		 * // Drawing the line canvas.lineTo(585, 300);
		 * 
		 * // Closing the path stroke canvas.closePathStroke();
		 */

		// doc.add(new Paragraph(
		// "iText Core is the library that allows you to create, process and edit PDF
		// documents"));
		// Closing the document
		doc.close();

		System.out.println("Background added successfully..");

		File file = new File(
				 pdfFile);

		byte[] contents = Files.readAllBytes(file.toPath());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		// Here you have to set the actual filename of your pdf
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = { "/doctorConsultingReceiptPdf" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> doctorConsultingReceiptPdf(@RequestParam("receiptNo") int receiptNo)
			throws IOException {

		GetDoctorConsultingReceipt getDoctorConsultingReceiptList = getDoctorConsultingReceiptRepository
				.getDoctorConsultingReceiptByReceiptNo(receiptNo);

		// Creating a PdfWriter object
		String dest = pdfFile;
		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		// Creating a table
		float[] pointColumnWidths = { 130F, 130F, 130F, 130F };
		Table table = new Table(pointColumnWidths);

		// Populating row 1 and adding it to the table
		Cell c1 = new Cell(); // Creating cell 1
		c1.add("Sr. No."); // Adding name to cell 1
		c1.setBackgroundColor(Color.DARK_GRAY); // Setting background color
		// c1.setBorder(Border.NO_BORDER); // Setting border
		c1.setTextAlignment(TextAlignment.CENTER); // Setting text alignment
		table.addCell(c1); // Adding cell 1 to the table

		Cell c2 = new Cell();
		c2.add("Txn Id");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		c2 = new Cell();
		c2.add("Payment clear Till");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		// Populating row 2 and adding it to the table
		Cell c3 = new Cell();
		c3.add("Amount");
		c3.setBackgroundColor(Color.GRAY);
		// c3.setBorder(Border.NO_BORDER);
		c3.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c3);

		Cell c4 = new Cell();
		c4.add(1 + "");
		// c4.setBackgroundColor(Color.WHITE);
		// c4.setBorder(Border.NO_BORDER);
		c4.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c4);

		// Populating row 3 and adding it to the table
		Cell c5 = new Cell();
		c5.add(getDoctorConsultingReceiptList.getTxnId());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		c5 = new Cell();
		c5.add(getDoctorConsultingReceiptList.getDate());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		Cell c6 = new Cell();
		c6.add(getDoctorConsultingReceiptList.getTotAmount() + "");
		// c6.setBackgroundColor(Color.GRAY);
		// c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Consulting Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getDoctorConsultingReceiptList.getTotAmount() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Commission Amount");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getDoctorConsultingReceiptList.getCommissionAmt() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getDoctorConsultingReceiptList.getPaidAmt() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		Text text1 = new Text(getDoctorConsultingReceiptList.getAddress() + "\n"
				+ getDoctorConsultingReceiptList.getContactNo1() + "\n" + getDoctorConsultingReceiptList.getEmail()
				+ "\nGSTN : " + getDoctorConsultingReceiptList.getCompanyGstNo());

		Text text2 = new Text(getDoctorConsultingReceiptList.getCompanyName() + "\n");

		// Setting font of the text
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		PdfFont font1 = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		text1.setFont(font1);

		// Setting font color
		text1.setFontColor(Color.BLACK);
		text2.setFontSize(15);
		text1.setFontSize(11);
		text2.setFont(font);

		String imFile = iconFile;
		ImageData data = ImageDataFactory.create(imFile);

		// Creating an Image object
		Image image = new Image(data);

		// Adding image to the document
		doc.add(image);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.setWidth(200);
		paragraph1.setRelativePosition(370, -40, 0, 0);
		paragraph1.add(text2);
		paragraph1.add(text1);
		doc.add(paragraph1);

		PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());

		// Initial point of the line
		canvas.moveTo(10, 680);

		// Drawing the line
		canvas.lineTo(585, 680);

		// Closing the path stroke
		canvas.closePathStroke();

		// table.setFixedPosition(10, 720, 585);

		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		Text invoceTo = new Text("INVOICE TO,\n");
		Text invoceToDetails = new Text(getDoctorConsultingReceiptList.getDoctorName() + "\nGSTN :- "
				+ getDoctorConsultingReceiptList.getGstNo());
		Paragraph paragraphInvoceTo = new Paragraph();
		invoceTo.setFont(font);
		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		invoceToDetails.setFont(font);
		invoceToDetails.setFontSize(11);
		invoceToDetails.setFontColor(Color.BLACK);

		// invoceToDetails.setFontSize(11);

		paragraphInvoceTo.add(invoceTo);
		paragraphInvoceTo.add(invoceToDetails);
		paragraphInvoceTo.setRelativePosition(20, -10, 0, 0);
		doc.add(paragraphInvoceTo);

		Paragraph paragraphInvoceNoAndDate = new Paragraph();

		Text invoceNo = new Text("INVOICE NO : ");

		invoceNo.setFont(font);
		paragraphInvoceNoAndDate.add(invoceNo);
		invoceNo = new Text(getDoctorConsultingReceiptList.getReceiptNo() + "\n");
		paragraphInvoceNoAndDate.add(invoceNo);
		Text invoceDate = new Text("Date :- ");
		invoceDate.setFont(font);
		invoceNo.setFontSize(12);
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate = new Text(getDoctorConsultingReceiptList.getCreatedDate() + "\n");
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate.setFontSize(11);

		paragraphInvoceNoAndDate.setRelativePosition(370, -80, 10, 0);
		doc.add(paragraphInvoceNoAndDate);

		Text text = new Text("Consulting Payment Receipt\n");
		text.setFontSize(12);
		text.setFont(font);
		Paragraph paragraphText = new Paragraph();
		paragraphText.add(text);

		paragraphText.setRelativePosition(200, -30, 0, 0);
		doc.add(paragraphText);

		// Adding Table to document
		table.setRelativePosition(10, 0, 0, 10);
		doc.add(table);

		Text thankU = new Text("Thank You !!\n");
		invoceNo.setFontSize(12);
		invoceDate.setFontSize(11);
		Paragraph paragraphThankU = new Paragraph();
		paragraphThankU.add(thankU);

		paragraphThankU.setRelativePosition(0, 5, 0, 0);
		doc.add(paragraphThankU);

		 
		doc.close();

		System.out.println("Background added successfully..");

		File file = new File( pdfFile);

		byte[] contents = Files.readAllBytes(file.toPath());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		// Here you have to set the actual filename of your pdf
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		return response;
	}

	
	
	
	
	@RequestMapping(value = { "/labSubscriptionReceiptPdf" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> labSubscriptionReceiptPdf(@RequestParam("suscriptionId") int suscriptionId)
			throws IOException {

		LabSuscriptionReceipt 	labSuscriptionReceipt=labSuscriptionReceiptRepository.getLabSuscriptionReceiptBySubscriptionId(suscriptionId);

		// Creating a PdfWriter object
		String dest = pdfFile;
		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		// Creating a table
		float[] pointColumnWidths = { 150F, 150F, 150F };
		Table table = new Table(pointColumnWidths);

		// Populating row 1 and adding it to the table
		Cell c1 = new Cell(); // Creating cell 1
		c1.add("Order Id"); // Adding name to cell 1
		c1.setBackgroundColor(Color.DARK_GRAY); // Setting background color
		// c1.setBorder(Border.NO_BORDER); // Setting border
		c1.setTextAlignment(TextAlignment.CENTER); // Setting text alignment
		table.addCell(c1); // Adding cell 1 to the table

		Cell c2 = new Cell();
		c2.add("Txn Id");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		// Populating row 2 and adding it to the table
		Cell c3 = new Cell();
		c3.add("Amount");
		c3.setBackgroundColor(Color.GRAY);
		// c3.setBorder(Border.NO_BORDER);
		c3.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c3);

		Cell c4 = new Cell();
		c4.add(labSuscriptionReceipt.getOrderId());
		// c4.setBackgroundColor(Color.WHITE);
		// c4.setBorder(Border.NO_BORDER);
		c4.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c4);

		// Populating row 3 and adding it to the table
		Cell c5 = new Cell();
		c5.add(labSuscriptionReceipt.getTxnId());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		Cell c6 = new Cell();
		c6.add(labSuscriptionReceipt.getAmount() + "");
		// c6.setBackgroundColor(Color.GRAY);
		// c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(labSuscriptionReceipt.getAmount() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		/*
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add(" "); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell();
		 * 
		 * c6.setTextAlignment(TextAlignment.CENTER); c6.setBorder(Border.NO_BORDER);
		 * table.addCell(c6);
		 * 
		 * c6 = new Cell();
		 * 
		 * c6.setTextAlignment(TextAlignment.CENTER); c6.setBorder(Border.NO_BORDER);
		 * table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add("Sub Total");
		 * c6.setTextAlignment(TextAlignment.CENTER); c6.setBorder(Border.NO_BORDER);
		 * table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add("1000.0"); c6.setBorder(Border.NO_BORDER);
		 * c6.setTextAlignment(TextAlignment.CENTER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add(" "); c6.setTextAlignment(TextAlignment.CENTER);
		 * c6.setBorder(Border.NO_BORDER); table.addCell(c6);
		 * 
		 * 
		 * 
		 * c6 = new Cell(); c6.add("Grand Total");
		 * c6.setTextAlignment(TextAlignment.CENTER); c6.setBorder(Border.NO_BORDER);
		 * table.addCell(c6);
		 * 
		 * c6 = new Cell(); c6.add("1000.0"); c6.setBorder(Border.NO_BORDER);
		 * c6.setTextAlignment(TextAlignment.CENTER); table.addCell(c6);
		 */

		Text text1 = new Text(labSuscriptionReceipt.getAddress() + "\n" + labSuscriptionReceipt.getContactNo1()
				+ "\n" + labSuscriptionReceipt.getEmail() + "\nGSTN : "
				+ labSuscriptionReceipt.getCompanyGstNo());

		Text text2 = new Text(labSuscriptionReceipt.getCompanyName() + "\n");

		// Setting font of the text
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		PdfFont font1 = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		text1.setFont(font1);

		// Setting font color
		text1.setFontColor(Color.BLACK);
		text2.setFontSize(15);
		text1.setFontSize(11);
		text2.setFont(font);

		String imFile = iconFile;
		ImageData data = ImageDataFactory.create(imFile);

		// Creating an Image object
		Image image = new Image(data);

		// Adding image to the document
		doc.add(image);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.setWidth(200);
		paragraph1.setRelativePosition(370, -40, 0, 0);
		paragraph1.add(text2);
		paragraph1.add(text1);
		doc.add(paragraph1);

		PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());

		// Initial point of the line
		canvas.moveTo(10, 680);

		// Drawing the line
		canvas.lineTo(585, 680);

		// Closing the path stroke
		canvas.closePathStroke();

		// table.setFixedPosition(10, 720, 585);

		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		Text invoceTo = new Text("INVOICE TO,\n");
		Text invoceToDetails = new Text(
				labSuscriptionReceipt.getLabName() + "\nGSTN :- " + labSuscriptionReceipt.getGstNo());
		Paragraph paragraphInvoceTo = new Paragraph();
		invoceTo.setFont(font);
		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		invoceToDetails.setFont(font);
		invoceToDetails.setFontSize(11);
		invoceToDetails.setFontColor(Color.BLACK);

		// invoceToDetails.setFontSize(11);

		paragraphInvoceTo.add(invoceTo);
		paragraphInvoceTo.add(invoceToDetails);
		paragraphInvoceTo.setRelativePosition(20, -10, 0, 0);
		doc.add(paragraphInvoceTo);

		Paragraph paragraphInvoceNoAndDate = new Paragraph();

		Text invoceNo = new Text("INVOICE NO : ");

		invoceNo.setFont(font);
		paragraphInvoceNoAndDate.add(invoceNo);
		invoceNo = new Text(labSuscriptionReceipt.getSuscriptionId() + "\n");
		paragraphInvoceNoAndDate.add(invoceNo);
		Text invoceDate = new Text("Date :- ");
		invoceDate.setFont(font);
		invoceNo.setFontSize(12);
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate = new Text(labSuscriptionReceipt.getCreatedDate() + "\n");
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate.setFontSize(11);

		paragraphInvoceNoAndDate.setRelativePosition(370, -80, 10, 0);
		doc.add(paragraphInvoceNoAndDate);

		Text text = new Text("Subscription Receipt\n");
		text.setFontSize(12);
		text.setFont(font);
		Paragraph paragraphText = new Paragraph();
		paragraphText.add(text);

		paragraphText.setRelativePosition(200, -30, 0, 0);
		doc.add(paragraphText);

		// Adding Table to document
		table.setRelativePosition(10, 0, 0, 10);
		doc.add(table);

		Text thankU = new Text("Thank You !!\n");
		invoceNo.setFontSize(12);
		invoceDate.setFontSize(11);
		Paragraph paragraphThankU = new Paragraph();
		paragraphThankU.add(thankU);

		paragraphThankU.setRelativePosition(0, 5, 0, 0);
		doc.add(paragraphThankU);

		/*
		 * Text subTotal = new Text("Sub Total : 1000\n"); subTotal.setFontSize(12);
		 * 
		 * Paragraph paragraphSubTotal = new Paragraph(); paragraphThankU.add(subTotal);
		 */

		/*
		 * thankU=new Text("Sub Total : 1000.0\n"); paragraphThankU= new Paragraph();
		 * paragraphThankU.add(thankU); paragraphThankU.setFixedPosition(350, 310, 200);
		 * doc.add(paragraphThankU);
		 * 
		 * 
		 * thankU=new Text("Grand Total : 1000.0\n"); paragraphThankU= new Paragraph();
		 * paragraphThankU.add(thankU); paragraphThankU.setFixedPosition(350, 280, 200);
		 * doc.add(paragraphThankU);
		 * 
		 * // Initial point of the line canvas.moveTo(300, 300);
		 * 
		 * // Drawing the line canvas.lineTo(585, 300);
		 * 
		 * // Closing the path stroke canvas.closePathStroke();
		 */

		// doc.add(new Paragraph(
		// "iText Core is the library that allows you to create, process and edit PDF
		// documents"));
		// Closing the document
		doc.close();

		System.out.println("Background added successfully..");

		File file = new File(
				 pdfFile);

		byte[] contents = Files.readAllBytes(file.toPath());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		// Here you have to set the actual filename of your pdf
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		return response;
	}

	
	
	@RequestMapping(value = { "/labReportReceiptPdf" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> labReportReceiptPdf(@RequestParam("receiptNo") int receiptNo)
			throws IOException {

		GetLabReportReceipt getLabReportReceipt = getLabReportReceiptRepository
				.getLabReportPaymentForReceipt(receiptNo);

		// Creating a PdfWriter object
		String dest = pdfFile;
		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		// Creating a table
		float[] pointColumnWidths = { 130F, 130F, 130F, 130F };
		Table table = new Table(pointColumnWidths);

		// Populating row 1 and adding it to the table
		Cell c1 = new Cell(); // Creating cell 1
		c1.add("Sr. No."); // Adding name to cell 1
		c1.setBackgroundColor(Color.DARK_GRAY); // Setting background color
		// c1.setBorder(Border.NO_BORDER); // Setting border
		c1.setTextAlignment(TextAlignment.CENTER); // Setting text alignment
		table.addCell(c1); // Adding cell 1 to the table

		Cell c2 = new Cell();
		c2.add("Txn Id");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		c2 = new Cell();
		c2.add("Payment clear Till");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		// Populating row 2 and adding it to the table
		Cell c3 = new Cell();
		c3.add("Amount");
		c3.setBackgroundColor(Color.GRAY);
		// c3.setBorder(Border.NO_BORDER);
		c3.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c3);

		Cell c4 = new Cell();
		c4.add(1 + "");
		// c4.setBackgroundColor(Color.WHITE);
		// c4.setBorder(Border.NO_BORDER);
		c4.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c4);

		// Populating row 3 and adding it to the table
		Cell c5 = new Cell();
		c5.add(getLabReportReceipt.getTxnId());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		c5 = new Cell();
		c5.add(getLabReportReceipt.getDate());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		Cell c6 = new Cell();
		c6.add(getLabReportReceipt.getTotAmount() + "");
		// c6.setBackgroundColor(Color.GRAY);
		// c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Consulting Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getLabReportReceipt.getTotAmount() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Commission Amount");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getLabReportReceipt.getCommissionAmt() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getLabReportReceipt.getPaidAmt() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		Text text1 = new Text(getLabReportReceipt.getAddress() + "\n"
				+ getLabReportReceipt.getContactNo1() + "\n" + getLabReportReceipt.getEmail()
				+ "\nGSTN : " + getLabReportReceipt.getCompanyGstNo());

		Text text2 = new Text(getLabReportReceipt.getCompanyName() + "\n");

		// Setting font of the text
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		PdfFont font1 = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		text1.setFont(font1);

		// Setting font color
		text1.setFontColor(Color.BLACK);
		text2.setFontSize(15);
		text1.setFontSize(11);
		text2.setFont(font);

		String imFile = iconFile;
		ImageData data = ImageDataFactory.create(imFile);

		// Creating an Image object
		Image image = new Image(data);

		// Adding image to the document
		doc.add(image);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.setWidth(200);
		paragraph1.setRelativePosition(370, -40, 0, 0);
		paragraph1.add(text2);
		paragraph1.add(text1);
		doc.add(paragraph1);

		PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());

		// Initial point of the line
		canvas.moveTo(10, 680);

		// Drawing the line
		canvas.lineTo(585, 680);

		// Closing the path stroke
		canvas.closePathStroke();

		// table.setFixedPosition(10, 720, 585);

		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		Text invoceTo = new Text("INVOICE TO,\n");
		Text invoceToDetails = new Text(getLabReportReceipt.getLabName() + "\nGSTN :- "
				+ getLabReportReceipt.getGstNo());
		Paragraph paragraphInvoceTo = new Paragraph();
		invoceTo.setFont(font);
		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		invoceToDetails.setFont(font);
		invoceToDetails.setFontSize(11);
		invoceToDetails.setFontColor(Color.BLACK);

		// invoceToDetails.setFontSize(11);

		paragraphInvoceTo.add(invoceTo);
		paragraphInvoceTo.add(invoceToDetails);
		paragraphInvoceTo.setRelativePosition(20, -10, 0, 0);
		doc.add(paragraphInvoceTo);

		Paragraph paragraphInvoceNoAndDate = new Paragraph();

		Text invoceNo = new Text("INVOICE NO : ");

		invoceNo.setFont(font);
		paragraphInvoceNoAndDate.add(invoceNo);
		invoceNo = new Text(getLabReportReceipt.getReceiptNo() + "\n");
		paragraphInvoceNoAndDate.add(invoceNo);
		Text invoceDate = new Text("Date :- ");
		invoceDate.setFont(font);
		invoceNo.setFontSize(12);
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate = new Text(getLabReportReceipt.getCreatedDate() + "\n");
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate.setFontSize(11);

		paragraphInvoceNoAndDate.setRelativePosition(370, -80, 10, 0);
		doc.add(paragraphInvoceNoAndDate);

		Text text = new Text("Reports Payment Receipt\n");
		text.setFontSize(12);
		text.setFont(font);
		Paragraph paragraphText = new Paragraph();
		paragraphText.add(text);

		paragraphText.setRelativePosition(200, -30, 0, 0);
		doc.add(paragraphText);

		// Adding Table to document
		table.setRelativePosition(10, 0, 0, 10);
		doc.add(table);

		Text thankU = new Text("Thank You !!\n");
		invoceNo.setFontSize(12);
		invoceDate.setFontSize(11);
		Paragraph paragraphThankU = new Paragraph();
		paragraphThankU.add(thankU);

		paragraphThankU.setRelativePosition(0, 5, 0, 0);
		doc.add(paragraphThankU);

		 
		doc.close();

		System.out.println("Background added successfully..");

		File file = new File( pdfFile);

		byte[] contents = Files.readAllBytes(file.toPath());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		// Here you have to set the actual filename of your pdf
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		return response;
	}
	
	
	@RequestMapping(value = { "/pharmacySubscriptionReceiptPdf" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> pharmacySubscriptionReceiptPdf(@RequestParam("suscriptionId") int suscriptionId)
			throws IOException {

		PharmacySuscriptionReceipt 	pharmacySuscriptionReceipt=pharmacySuscriptionReceiptRepository.getPharmacySuscriptionReceiptBySubscriptionId(suscriptionId);

		// Creating a PdfWriter object
		String dest = pdfFile;
		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		// Creating a table
		float[] pointColumnWidths = { 150F, 150F, 150F };
		Table table = new Table(pointColumnWidths);

		// Populating row 1 and adding it to the table
		Cell c1 = new Cell(); // Creating cell 1
		c1.add("Order Id"); // Adding name to cell 1
		c1.setBackgroundColor(Color.DARK_GRAY); // Setting background color
		// c1.setBorder(Border.NO_BORDER); // Setting border
		c1.setTextAlignment(TextAlignment.CENTER); // Setting text alignment
		table.addCell(c1); // Adding cell 1 to the table

		Cell c2 = new Cell();
		c2.add("Txn Id");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		// Populating row 2 and adding it to the table
		Cell c3 = new Cell();
		c3.add("Amount");
		c3.setBackgroundColor(Color.GRAY);
		// c3.setBorder(Border.NO_BORDER);
		c3.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c3);

		Cell c4 = new Cell();
		c4.add(pharmacySuscriptionReceipt.getOrderId());
		// c4.setBackgroundColor(Color.WHITE);
		// c4.setBorder(Border.NO_BORDER);
		c4.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c4);

		// Populating row 3 and adding it to the table
		Cell c5 = new Cell();
		c5.add(pharmacySuscriptionReceipt.getTxnId());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		Cell c6 = new Cell();
		c6.add(pharmacySuscriptionReceipt.getAmount() + "");
		// c6.setBackgroundColor(Color.GRAY);
		// c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(pharmacySuscriptionReceipt.getAmount() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		 

		Text text1 = new Text(pharmacySuscriptionReceipt.getAddress() + "\n" + pharmacySuscriptionReceipt.getContactNo1()
				+ "\n" + pharmacySuscriptionReceipt.getEmail() + "\nGSTN : "
				+ pharmacySuscriptionReceipt.getCompanyGstNo());

		Text text2 = new Text(pharmacySuscriptionReceipt.getCompanyName() + "\n");

		// Setting font of the text
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		PdfFont font1 = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		text1.setFont(font1);

		// Setting font color
		text1.setFontColor(Color.BLACK);
		text2.setFontSize(15);
		text1.setFontSize(11);
		text2.setFont(font);

		String imFile = iconFile;
		ImageData data = ImageDataFactory.create(imFile);

		// Creating an Image object
		Image image = new Image(data);

		// Adding image to the document
		doc.add(image);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.setWidth(200);
		paragraph1.setRelativePosition(370, -40, 0, 0);
		paragraph1.add(text2);
		paragraph1.add(text1);
		doc.add(paragraph1);

		PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());

		// Initial point of the line
		canvas.moveTo(10, 680);

		// Drawing the line
		canvas.lineTo(585, 680);

		// Closing the path stroke
		canvas.closePathStroke();

		// table.setFixedPosition(10, 720, 585);

		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		Text invoceTo = new Text("INVOICE TO,\n");
		Text invoceToDetails = new Text(
				pharmacySuscriptionReceipt.getPharmacyName() + "\nGSTN :- " + pharmacySuscriptionReceipt.getGstNo());
		Paragraph paragraphInvoceTo = new Paragraph();
		invoceTo.setFont(font);
		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		invoceToDetails.setFont(font);
		invoceToDetails.setFontSize(11);
		invoceToDetails.setFontColor(Color.BLACK);

		// invoceToDetails.setFontSize(11);

		paragraphInvoceTo.add(invoceTo);
		paragraphInvoceTo.add(invoceToDetails);
		paragraphInvoceTo.setRelativePosition(20, -10, 0, 0);
		doc.add(paragraphInvoceTo);

		Paragraph paragraphInvoceNoAndDate = new Paragraph();

		Text invoceNo = new Text("INVOICE NO : ");

		invoceNo.setFont(font);
		paragraphInvoceNoAndDate.add(invoceNo);
		invoceNo = new Text(pharmacySuscriptionReceipt.getSuscriptionId() + "\n");
		paragraphInvoceNoAndDate.add(invoceNo);
		Text invoceDate = new Text("Date :- ");
		invoceDate.setFont(font);
		invoceNo.setFontSize(12);
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate = new Text(pharmacySuscriptionReceipt.getCreatedDate() + "\n");
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate.setFontSize(11);

		paragraphInvoceNoAndDate.setRelativePosition(370, -80, 10, 0);
		doc.add(paragraphInvoceNoAndDate);

		Text text = new Text("Subscription Receipt\n");
		text.setFontSize(12);
		text.setFont(font);
		Paragraph paragraphText = new Paragraph();
		paragraphText.add(text);

		paragraphText.setRelativePosition(200, -30, 0, 0);
		doc.add(paragraphText);

		// Adding Table to document
		table.setRelativePosition(10, 0, 0, 10);
		doc.add(table);

		Text thankU = new Text("Thank You !!\n");
		invoceNo.setFontSize(12);
		invoceDate.setFontSize(11);
		Paragraph paragraphThankU = new Paragraph();
		paragraphThankU.add(thankU);

		paragraphThankU.setRelativePosition(0, 5, 0, 0);
		doc.add(paragraphThankU);

		/*
		 * Text subTotal = new Text("Sub Total : 1000\n"); subTotal.setFontSize(12);
		 * 
		 * Paragraph paragraphSubTotal = new Paragraph(); paragraphThankU.add(subTotal);
		 */

		/*
		 * thankU=new Text("Sub Total : 1000.0\n"); paragraphThankU= new Paragraph();
		 * paragraphThankU.add(thankU); paragraphThankU.setFixedPosition(350, 310, 200);
		 * doc.add(paragraphThankU);
		 * 
		 * 
		 * thankU=new Text("Grand Total : 1000.0\n"); paragraphThankU= new Paragraph();
		 * paragraphThankU.add(thankU); paragraphThankU.setFixedPosition(350, 280, 200);
		 * doc.add(paragraphThankU);
		 * 
		 * // Initial point of the line canvas.moveTo(300, 300);
		 * 
		 * // Drawing the line canvas.lineTo(585, 300);
		 * 
		 * // Closing the path stroke canvas.closePathStroke();
		 */

		// doc.add(new Paragraph(
		// "iText Core is the library that allows you to create, process and edit PDF
		// documents"));
		// Closing the document
		doc.close();

		System.out.println("Background added successfully..");

		File file = new File(
				 pdfFile);

		byte[] contents = Files.readAllBytes(file.toPath());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		// Here you have to set the actual filename of your pdf
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		return response;
	}

	

	@RequestMapping(value = { "/pharmacyPrescriptionReceiptPdf" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> pharmacyPrescriptionReceiptPdf(@RequestParam("receiptNo") int receiptNo)
			throws IOException {

		GetPharmacyPrescriptionReceipt getPharmacyPrescriptionReceipt = getPharmacyPrescriptionReceiptRepository
				.getPharmacyPrescriptionPaymentForReceipt(receiptNo);

		// Creating a PdfWriter object
		String dest = pdfFile;
		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		// Creating a table
		float[] pointColumnWidths = { 130F, 130F, 130F, 130F };
		Table table = new Table(pointColumnWidths);

		// Populating row 1 and adding it to the table
		Cell c1 = new Cell(); // Creating cell 1
		c1.add("Sr. No."); // Adding name to cell 1
		c1.setBackgroundColor(Color.DARK_GRAY); // Setting background color
		// c1.setBorder(Border.NO_BORDER); // Setting border
		c1.setTextAlignment(TextAlignment.CENTER); // Setting text alignment
		table.addCell(c1); // Adding cell 1 to the table

		Cell c2 = new Cell();
		c2.add("Txn Id");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		c2 = new Cell();
		c2.add("Payment clear Till");
		c2.setBackgroundColor(Color.GRAY);
		// c2.setBorder(Border.NO_BORDER);
		c2.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c2);

		// Populating row 2 and adding it to the table
		Cell c3 = new Cell();
		c3.add("Amount");
		c3.setBackgroundColor(Color.GRAY);
		// c3.setBorder(Border.NO_BORDER);
		c3.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c3);

		Cell c4 = new Cell();
		c4.add(1 + "");
		// c4.setBackgroundColor(Color.WHITE);
		// c4.setBorder(Border.NO_BORDER);
		c4.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c4);

		// Populating row 3 and adding it to the table
		Cell c5 = new Cell();
		c5.add(getPharmacyPrescriptionReceipt.getTxnId());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		c5 = new Cell();
		c5.add(getPharmacyPrescriptionReceipt.getDate());
		// c5.setBackgroundColor(Color.DARK_GRAY);
		// c5.setBorder(Border.);
		c5.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c5);

		Cell c6 = new Cell();
		c6.add(getPharmacyPrescriptionReceipt.getTotAmount() + "");
		// c6.setBackgroundColor(Color.GRAY);
		// c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Consulting Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getPharmacyPrescriptionReceipt.getTotAmount() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Commission Amount");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getPharmacyPrescriptionReceipt.getCommissionAmt() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setTextAlignment(TextAlignment.CENTER);
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		table.addCell(c6);

		c6 = new Cell();
		c6.add("Total");
		c6.setBorder(Border.NO_BORDER);
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		c6 = new Cell();
		c6.setBorder(Border.NO_BORDER);
		c6.add(getPharmacyPrescriptionReceipt.getPaidAmt() + "");
		c6.setTextAlignment(TextAlignment.CENTER);
		table.addCell(c6);

		Text text1 = new Text(getPharmacyPrescriptionReceipt.getAddress() + "\n"
				+ getPharmacyPrescriptionReceipt.getContactNo1() + "\n" + getPharmacyPrescriptionReceipt.getEmail()
				+ "\nGSTN : " + getPharmacyPrescriptionReceipt.getCompanyGstNo());

		Text text2 = new Text(getPharmacyPrescriptionReceipt.getCompanyName() + "\n");

		// Setting font of the text
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		PdfFont font1 = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		text1.setFont(font1);

		// Setting font color
		text1.setFontColor(Color.BLACK);
		text2.setFontSize(15);
		text1.setFontSize(11);
		text2.setFont(font);

		String imFile = iconFile;
		ImageData data = ImageDataFactory.create(imFile);

		// Creating an Image object
		Image image = new Image(data);

		// Adding image to the document
		doc.add(image);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.setWidth(200);
		paragraph1.setRelativePosition(370, -40, 0, 0);
		paragraph1.add(text2);
		paragraph1.add(text1);
		doc.add(paragraph1);

		PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());

		// Initial point of the line
		canvas.moveTo(10, 680);

		// Drawing the line
		canvas.lineTo(585, 680);

		// Closing the path stroke
		canvas.closePathStroke();

		// table.setFixedPosition(10, 720, 585);

		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		Text invoceTo = new Text("INVOICE TO,\n");
		Text invoceToDetails = new Text(getPharmacyPrescriptionReceipt.getMedicalName() + "\nGSTN :- "
				+ getPharmacyPrescriptionReceipt.getGstNo());
		Paragraph paragraphInvoceTo = new Paragraph();
		invoceTo.setFont(font);
		font = PdfFontFactory.createFont(FontConstants.TIMES_BOLDITALIC);
		invoceToDetails.setFont(font);
		invoceToDetails.setFontSize(11);
		invoceToDetails.setFontColor(Color.BLACK);

		// invoceToDetails.setFontSize(11);

		paragraphInvoceTo.add(invoceTo);
		paragraphInvoceTo.add(invoceToDetails);
		paragraphInvoceTo.setRelativePosition(20, -10, 0, 0);
		doc.add(paragraphInvoceTo);

		Paragraph paragraphInvoceNoAndDate = new Paragraph();

		Text invoceNo = new Text("INVOICE NO : ");

		invoceNo.setFont(font);
		paragraphInvoceNoAndDate.add(invoceNo);
		invoceNo = new Text(getPharmacyPrescriptionReceipt.getReceiptNo() + "\n");
		paragraphInvoceNoAndDate.add(invoceNo);
		Text invoceDate = new Text("Date :- ");
		invoceDate.setFont(font);
		invoceNo.setFontSize(12);
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate = new Text(getPharmacyPrescriptionReceipt.getCreatedDate() + "\n");
		paragraphInvoceNoAndDate.add(invoceDate);
		invoceDate.setFontSize(11);

		paragraphInvoceNoAndDate.setRelativePosition(370, -80, 10, 0);
		doc.add(paragraphInvoceNoAndDate);

		Text text = new Text("Pharmcy Prescription Payment Receipt\n");
		text.setFontSize(12);
		text.setFont(font);
		Paragraph paragraphText = new Paragraph();
		paragraphText.add(text);

		paragraphText.setRelativePosition(200, -30, 0, 0);
		doc.add(paragraphText);

		// Adding Table to document
		table.setRelativePosition(10, 0, 0, 10);
		doc.add(table);

		Text thankU = new Text("Thank You !!\n");
		invoceNo.setFontSize(12);
		invoceDate.setFontSize(11);
		Paragraph paragraphThankU = new Paragraph();
		paragraphThankU.add(thankU);

		paragraphThankU.setRelativePosition(0, 5, 0, 0);
		doc.add(paragraphThankU);

		 
		doc.close();

		System.out.println("Background added successfully..");

		File file = new File( pdfFile);

		byte[] contents = Files.readAllBytes(file.toPath());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		// Here you have to set the actual filename of your pdf
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		return response;
	}
	
	
	
}
