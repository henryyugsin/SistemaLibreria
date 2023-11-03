
package bimax3.pkg0;

import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

public class PDF {
     public String[] facturador= new String[8];
     public String[] factura= new String[12];
     public String[] comprador= new String[7];
     public String[] finales= new String[15];
     public int numeroproductos;
     public String[][] productos= new String[numeroproductos][10];
     
    public PDF() {
    }
     
    protected void manipulatePdf(String dest, String[] dFacturador,String[] dFactura,String[] dComprador,String[] dfinales,int numeroproductos1, String[][] productos1) throws Exception {
        this.facturador = dFacturador;
        this.factura=dFactura;
        this.comprador=dComprador;
        this.finales=dfinales;
        this.numeroproductos=numeroproductos1;
        this.productos=productos1;
        //Datos Facturador
        String razonsocial = facturador[0];
        String nombrecomercial=facturador[1];
        String direccionmatriz=facturador[2];
        String direccionsucursal=facturador[3];
        String obligadocontabilidad=facturador[4];
        String ruc =facturador[5];
        String tipocontribuyente =facturador[7];
        //Datos Factura
        String nestab = factura[0];
        String nfacturero=factura[1];
        String nfactura=factura[2];
        String nautorizacion=factura[3];
        String dia=factura[4];
        String mes =factura[5];
        String año = factura[6];
        String hora = factura[7];
        String minutos = factura[8];
        String segundos = factura[9];
        String ambiente = factura[10];
        String emision = factura[11];
        //Datos Comprador
        String nombre = comprador[0];
        String identificacion =comprador[1];
        String direccion = comprador[2];
        String matricula = comprador[3];
        String guia = comprador[4];
        String email = comprador[5];
        String telefono = comprador[6];
        //Datos productos
        
        String[] codprincipal = new String[numeroproductos];
        String[] codsecundario = new String[numeroproductos];
        String[] cantidad = new String[numeroproductos];
        String[] descripcion = new String[numeroproductos];
        String[] detalle = new String[numeroproductos];
        String[] precioUnitario = new String[numeroproductos];
        String[] subsidio = new String[numeroproductos];
        String[] preciosinSubcidio = new String[numeroproductos];
        String[] descuento = new String[numeroproductos];
        String[] precioTotal = new String[numeroproductos];
        for (int i=0;i<numeroproductos;i++){
        codprincipal[i]=productos[i][0];
        codsecundario[i]=productos[i][1];
        cantidad[i]=productos[i][2];
        descripcion[i]=productos[i][3];
        detalle[i]=productos[i][4];
        precioUnitario[i]=productos[i][5];
        subsidio[i]=productos[i][6];
        preciosinSubcidio[i]=productos[i][7];
        descuento[i]=productos[i][8];
        precioTotal[i]=productos[i][9];
        }
        //Datos Finales Factura
        String subtotal12 = finales[0];
        String subtotal0 = finales[1];
        String subtotalnoobjeto = finales[2];
        String subtotalexentoiva = finales[3];
        String subtotalsinimpuestos = finales[4];
        String totaldescuento = finales[5];
        String ice = finales[6];
        String iva12 = finales[7];
        String totaldevolucioniva = finales[8];
        String irbpnr = finales[9];
        String propina = finales[10];
        String valorTotal = finales[11];
        String valorTotalsinsubsidio = finales[12];
        String ahorroporsubsidio = finales[13];
        String formadePago = finales[14];
        
        
        //Creo el documento pdf
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc, PageSize.A4);
        //Insertar el Logo en el PDF
        ImageData imageData = ImageDataFactory.create(facturador[6]);
        Image img = new Image(imageData);
        img.setWidth(240f);
        img.setHeight(100f);
       
        //Crear la tabla donde se ubicara la imagen
        Table tableima = new Table(1);
        tableima.addCell(img);
        tableima.setFixedPosition(35, 695, 0);
        doc.add(tableima);
        //Creo la primera tabla
        Table table1 = new Table(1);
        
        //Añado cada uno de los atributos correspondientes
        table1.addCell(new Cell().add(new Paragraph(razonsocial)).setBorder(Border.NO_BORDER));
        table1.addCell(new Cell().add(new Paragraph(nombrecomercial)).setBorder(Border.NO_BORDER));
        table1.addCell(new Cell().add(new Paragraph("Direccion Matriz: "+direccionmatriz)).setBorder(Border.NO_BORDER));
        table1.addCell(new Cell().add(new Paragraph("Direccion Sucursal: "+direccionsucursal)).setBorder(Border.NO_BORDER));
        table1.addCell(new Cell().add(new Paragraph("Obligado Contabilidad: "+obligadocontabilidad)).setBorder(Border.NO_BORDER));
        table1.addCell(new Cell().add(new Paragraph("Tipo Contribuyente: ")).setBorder(Border.NO_BORDER));
        table1.addCell(new Cell().add(new Paragraph(tipocontribuyente)).setBorder(Border.NO_BORDER));
        table1.setHeight(180f);
        table1.setMinWidth(250f);
        //Creo tabla para que contenga la tabla anterior
        Table table12 = new Table(1);
        table12.addCell(new Cell().add(new Paragraph("")));
        table12.setHeight(180f);
        table12.setMinWidth(250f);
        
        //Creo codigo de barras
        String code = nautorizacion;
        Barcode128 barcode = new Barcode128(pdfDoc);
        barcode.setCodeType(Barcode128.CODE128);
        barcode.setCode(code);
        // Create barcode object to put it to the cell as image
        PdfFormXObject barcodeObject = barcode.createFormXObject(null, null, pdfDoc);
        Cell cell = new Cell().add(new Image(barcodeObject)).setBorder(Border.NO_BORDER);
        
        //Creo la segunda tabla 
        Table table2 = new Table(1);
        //Añado cada uno de los atributos correspondientes
        table2.addCell(new Cell().add(new Paragraph("R.U.C: "+ruc)).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("FACTURA")).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("No: "+nestab+"-"+nfacturero+"-"+nfactura)).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("NUMERO DE AUTORIZACION")).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph(nautorizacion)).setBorder(Border.NO_BORDER)).setFontSize(10);
        table2.addCell(new Cell().add(new Paragraph("FECHA Y HORA AUTORIZACION: "+dia+"/"+mes+"/"+año+" "+hora+":"+minutos+":"+segundos)).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("AMBIENTE: "+ambiente)).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("EMISION: "+emision)).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("CLAVE DE ACCESO")).setBorder(Border.NO_BORDER));
        table2.addCell(cell).setMarginLeft(200);
        table2.setHeight(300f);
        table2.setMinWidth(280f);
        //Creo la tabla que contiene a tabla 2 
        Table table21 = new Table(1);
        table21.addCell(new Cell().add(new Paragraph("")));
        table21.setHeight(300f);
        table21.setMinWidth(280f);
        //Creo la tabla 3
        Table table3 = new Table(2);
        table3.addCell(new Cell().add(new Paragraph("Razon Social/Nombre: "+nombre)).setBorder(Border.NO_BORDER));
        table3.addCell(new Cell().add(new Paragraph("Identificacion: "+identificacion)).setBorder(Border.NO_BORDER));
        table3.addCell(new Cell().add(new Paragraph("Fecha de Emision: "+dia+"/"+mes+"/"+año)).setBorder(Border.NO_BORDER));
        table3.addCell(new Cell().add(new Paragraph("Guia de Remision: "+guia)).setBorder(Border.NO_BORDER));
        table3.addCell(new Cell().add(new Paragraph("Direccion Cliente: "+direccion)).setBorder(Border.NO_BORDER));
        table3.setHeight(50f);
        table3.setMinWidth(550f);
        //Creo la tabla que contiene a tabla 3
        Table table31 = new Table(2);
        table31.addCell(new Cell().add(new Paragraph("")));
        table31.setHeight(50f);
        table31.setMinWidth(550f);
        //Definir posiciones
        table1.setFixedPosition(35, 500, 0);
        table12.setFixedPosition(35, 500, 0);
        table2.setFixedPosition(295, 500, 0);
        table21.setFixedPosition(295, 500, 0);
        table3.setFixedPosition(35, 440, 0);
        table31.setFixedPosition(35, 440, 0);
        //Añadir al PDF
        doc.add(table1);
        doc.add(table12);
        doc.add(table2);
        doc.add(table21);
        doc.add(table3);
        doc.add(table31);
        
        
        //Creo la tabla para productos
        
        if(numeroproductos<6){
        float[] columnWidths1 = {150f,150f,150f,1000f,1000f,500f,500f,500f,500f,500f};
        Table tablep = new Table(UnitValue.createPercentArray(columnWidths1));
        for (int i = 0; i < numeroproductos+1; i++) {
            if (i==0){
            Cell cel1 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Cod.Principal")).setHeight(30).setFontSize(8);
            Cell cel2 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Cod.Auxiliar" )).setHeight(30).setFontSize(8);
            Cell cel3 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Cantidad")).setHeight(30).setFontSize(8);
            Cell cel4 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Descripcion")).setHeight(30).setFontSize(8);
            Cell cel5 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Detalle Adicional")).setHeight(30).setFontSize(8);
            Cell cel6 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Precio Unitario")).setHeight(30).setFontSize(8);
            Cell cel7 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Subsidio")).setHeight(30).setFontSize(8);
            Cell cel8 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Precio sin Subsidio")).setHeight(30).setFontSize(8);
            Cell cel9 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Descuento")).setHeight(30).setFontSize(8);
            Cell cel10 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Precio Total")).setHeight(30).setFontSize(8);
            tablep.addCell(cel1);
            tablep.addCell(cel2);
            tablep.addCell(cel3);
            tablep.addCell(cel4);
            tablep.addCell(cel5);
            tablep.addCell(cel6);
            tablep.addCell(cel7);
            tablep.addCell(cel8);
            tablep.addCell(cel9);
            tablep.addCell(cel10);
            }else{
            Cell cel1 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(codprincipal[i-1])).setHeight(30).setFontSize(8);
            Cell cel2 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(codsecundario[i-1])).setHeight(30).setFontSize(8);
            Cell cel3 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(cantidad[i-1])).setHeight(30).setFontSize(8);
            Cell cel4 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(descripcion[i-1])).setHeight(30).setFontSize(8);
            Cell cel5 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(detalle[i-1])).setHeight(30).setFontSize(8);
            Cell cel6 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(precioUnitario[i-1])).setHeight(30).setFontSize(8);
            Cell cel7 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(subsidio[i-1])).setHeight(30).setFontSize(8);
            Cell cel8 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(preciosinSubcidio[i-1])).setHeight(30).setFontSize(8);
            Cell cel9 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(descuento[i-1])).setHeight(30).setFontSize(8);
            Cell cel10 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(precioTotal[i-1])).setHeight(30).setFontSize(8);
            tablep.addCell(cel1);
            tablep.addCell(cel2);
            tablep.addCell(cel3);
            tablep.addCell(cel4);
            tablep.addCell(cel5);
            tablep.addCell(cel6);
            tablep.addCell(cel7);
            tablep.addCell(cel8);
            tablep.addCell(cel9);
            tablep.addCell(cel10);
            }
        }
          
        //Definir posiciones 
        tablep.setRelativePosition(0, 380, 0,0);
        tablep.setMinWidth(550f);
        //Añadir al PDF
        doc.add(tablep);
        //Crear la tabla final 
        float[] columnWidths2 = {150f,50f};
        Table tablef = new Table(UnitValue.createPercentArray(columnWidths2));
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL 12% "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotal12))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL 0% "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotal0))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL NO OBJETO DE IVA "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotalnoobjeto))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL EXCENTO DE IVA "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotalexentoiva))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL SIN IMPUESTOS "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotalsinimpuestos))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("TOTAL DESCUENTO "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(totaldescuento))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("ICE "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(ice))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("IVA 12% "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(iva12))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("TOTAL DEVOLUCION IVA"))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(totaldevolucioniva))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("IRBPNR "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(irbpnr))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("PROPINA "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(propina))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("VALOR TOTAL "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(valorTotal))).setFontSize(8);
        //Definir ancho 
        tablef.setMinWidth(150f);
        //Definir posiciones
        tablef.setRelativePosition(380, 380, 0,0);
        //Añadir al documento
        doc.add(tablef);
        //Añadir tabla Informacion Adicional
        float[] columnWidths3 = {1};
        Table tableI = new Table(UnitValue.createPercentArray(columnWidths3));
        tableI.addCell(new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("INFORMACION ADICIONAL "))).setFontSize(8);
        tableI.addCell(new Cell().add(new Paragraph("EMAIL: "+email))).setFontSize(8);
        tableI.addCell(new Cell().add(new Paragraph("DIRECCION: "+direccion))).setFontSize(8);
        tableI.addCell(new Cell().add(new Paragraph("TELEFONO: "+telefono))).setFontSize(8);
        //Definir ancho 
        tableI.setMaxWidth(350);
       
        //Definir posiciones
        tableI.setRelativePosition(0, 185, 0,0);
        //Añadir al documento
        doc.add(tableI);
        //Añadir tabla Detalle del Pago
        Table tableP = new Table(2);
        tableP.addCell(new Cell().add(new Paragraph("FORMA DE PAGO "))).setFontSize(8);
        tableP.addCell(new Cell().add(new Paragraph("VALOR"))).setFontSize(8);
        tableP.addCell(new Cell().add(new Paragraph(formadePago))).setFontSize(8);
        tableP.addCell(new Cell().add(new Paragraph(valorTotal))).setFontSize(8);
        //Definir ancho 
        tableP.setMaxWidth(350f);
        //Definir posiciones
        tableP.setRelativePosition(0, 190, 0,0);
        //Añadir al documento
        doc.add(tableP);
        
        //Añadir tabla Subsidio
        Table tableS = new Table(1);
        tableS.addCell(new Cell().add(new Paragraph("VALOR TOTAL SIN SUBSIDIO:    "+valorTotalsinsubsidio))).setFontSize(8);
        tableS.addCell(new Cell().add(new Paragraph("AHORRO POR SUBSIDIO (Incluya el IVA cuando corresponda):   "+ahorroporsubsidio))).setFontSize(8);
        //Definir ancho 
        tableS.setMaxWidth(350f);
        //Definir posiciones
        tableS.setRelativePosition(0, 195, 0,0);
        //Añadir al documento
        doc.add(tableS);
        }else{
            //Calcular el numero de hojas que necesito
            double n1=numeroproductos;
            double n2=14;
            double au= n1/n2;
            int numerohojas = (int) Math.ceil(au);
            int numerocomienzo=0;
            int nvar=0;
            int contador=0;
            for (int j = 0; j < numerohojas; j++) {
            int productosimprimirse=14;
                
        float[] columnWidths1 = {150f,150f,150f,1000f,1000f,500f,500f,500f,500f,500f};
        Table tablep = new Table(UnitValue.createPercentArray(columnWidths1));
        
        for (int i = 0; i < productosimprimirse+1; i++) {
            if (i==0){
            Cell cel1 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Cod.Principal")).setHeight(30).setFontSize(8);
            Cell cel2 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Cod.Auxiliar" )).setHeight(30).setFontSize(8);
            Cell cel3 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Cantidad")).setHeight(30).setFontSize(8);
            Cell cel4 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Descripcion")).setHeight(30).setFontSize(8);
            Cell cel5 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Detalle Adicional")).setHeight(30).setFontSize(8);
            Cell cel6 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Precio Unitario")).setHeight(30).setFontSize(8);
            Cell cel7 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Subsidio")).setHeight(30).setFontSize(8);
            Cell cel8 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Precio sin Subsidio")).setHeight(30).setFontSize(8);
            Cell cel9 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Descuento")).setHeight(30).setFontSize(8);
            Cell cel10 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("Precio Total")).setHeight(30).setFontSize(8);
            tablep.addCell(cel1);
            tablep.addCell(cel2);
            tablep.addCell(cel3);
            tablep.addCell(cel4);
            tablep.addCell(cel5);
            tablep.addCell(cel6);
            tablep.addCell(cel7);
            tablep.addCell(cel8);
            tablep.addCell(cel9);
            tablep.addCell(cel10);
            }else{
            Cell cel1 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(codprincipal[contador])).setHeight(30).setFontSize(8);
            Cell cel2 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(codsecundario[contador])).setHeight(30).setFontSize(8);
            Cell cel3 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(cantidad[contador])).setHeight(30).setFontSize(8);
            Cell cel4 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(descripcion[contador])).setHeight(30).setFontSize(8);
            Cell cel5 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(detalle[contador])).setHeight(30).setFontSize(8);
            Cell cel6 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(precioUnitario[contador])).setHeight(30).setFontSize(8);
            Cell cel7 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(subsidio[contador])).setHeight(30).setFontSize(8);
            Cell cel8 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(preciosinSubcidio[contador])).setHeight(30).setFontSize(8);
            Cell cel9 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(descuento[contador])).setHeight(30).setFontSize(8);
            Cell cel10 = new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph(precioTotal[contador])).setHeight(30).setFontSize(8);
            tablep.addCell(cel1);
            tablep.addCell(cel2);
            tablep.addCell(cel3);
            tablep.addCell(cel4);
            tablep.addCell(cel5);
            tablep.addCell(cel6);
            tablep.addCell(cel7);
            tablep.addCell(cel8);
            tablep.addCell(cel9);
            tablep.addCell(cel10);
            contador=contador+1;
            }
            productosimprimirse=numeroproductos-(j+1)*14;
            if(productosimprimirse<=0){
                    productosimprimirse=14-(numeroproductos-(j+1)*14)*(-1);
                    if(productosimprimirse<5){
                        nvar=50;
                    }else{
                        nvar=10;
                    }
                    
            }else{
                 productosimprimirse=14;   
            }
        }
          
        //Definir posiciones 
        numerocomienzo=850-(productosimprimirse+1)*38-nvar;
        tablep.setFixedPosition(j+2, 40,numerocomienzo, 0);
        tablep.setMinWidth(550f);
        //Añadir al PDF
        doc.add(tablep);
            }
            //Crear la tabla final 
        float[] columnWidths2 = {150f,50f};
        Table tablef = new Table(UnitValue.createPercentArray(columnWidths2));
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL 12% "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotal12))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL 0% "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotal0))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL NO OBJETO DE IVA "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotalnoobjeto))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL EXCENTO DE IVA "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotalexentoiva))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("SUBTOTAL SIN IMPUESTOS "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(subtotalsinimpuestos))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("TOTAL DESCUENTO "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(totaldescuento))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("ICE "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(ice))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("IVA 12% "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(iva12))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("TOTAL DEVOLUCION IVA"))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(totaldevolucioniva))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("IRBPNR "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(irbpnr))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("PROPINA "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(propina))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph("VALOR TOTAL "))).setFontSize(8);
        tablef.addCell(new Cell().add(new Paragraph(valorTotal))).setFontSize(8);
        //Definir ancho 
        tablef.setMinWidth(150f);
        //Definir posiciones
        tablef.setFixedPosition(numerohojas+1, 420,numerocomienzo-230, 0);
        //Añadir al documento
        doc.add(tablef);
        //Añadir tabla Informacion Adicional
        float[] columnWidths3 = {1};
        Table tableI = new Table(UnitValue.createPercentArray(columnWidths3));
        tableI.addCell(new Cell().setTextAlignment(TextAlignment.JUSTIFIED).add(new Paragraph("INFORMACION ADICIONAL "))).setFontSize(8);
        tableI.addCell(new Cell().add(new Paragraph("EMAIL: "+email))).setFontSize(8);
        tableI.addCell(new Cell().add(new Paragraph("DIRECCION: "+direccion))).setFontSize(8);
        tableI.addCell(new Cell().add(new Paragraph("TELEFONO: "+telefono))).setFontSize(8);
        //Definir ancho 
        tableI.setMinWidth(350);
        tableI.setMaxHeight(80);
        //Definir posiciones
        tableI.setFixedPosition(numerohojas+1, 40,numerocomienzo-100, 0);
        //Añadir al documento
        doc.add(tableI);
        //Añadir tabla Detalle del Pago
        Table tableP = new Table(2);
        tableP.addCell(new Cell().add(new Paragraph("FORMA DE PAGO "))).setFontSize(8);
        tableP.addCell(new Cell().add(new Paragraph("VALOR"))).setFontSize(8);
        tableP.addCell(new Cell().add(new Paragraph(formadePago))).setFontSize(8);
        tableP.addCell(new Cell().add(new Paragraph(valorTotal))).setFontSize(8);
        //Definir ancho 
        tableP.setMinWidth(350f);
        //Definir posiciones
        tableP.setFixedPosition(numerohojas+1, 40,numerocomienzo-145, 0);
        //Añadir al documento
        doc.add(tableP);
        
        //Añadir tabla Subsidio
        Table tableS = new Table(1);
        tableS.addCell(new Cell().add(new Paragraph("VALOR TOTAL SIN SUBSIDIO:    "+valorTotalsinsubsidio))).setFontSize(8);
        tableS.addCell(new Cell().add(new Paragraph("AHORRO POR SUBSIDIO (Incluya el IVA cuando corresponda):   "+ahorroporsubsidio))).setFontSize(8);
        //Definir ancho 
        tableS.setMinWidth(350f);
        //Definir posiciones
        tableS.setFixedPosition(numerohojas+1, 40,numerocomienzo-185, 0);
        //Añadir al documento
        doc.add(tableS);
         
            
        }
        //Cierro el documento
        doc.close();
    
    }
    
}

