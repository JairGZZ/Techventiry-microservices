package com.example.jairdev.Report_Microservice.service;

import com.example.jairdev.Report_Microservice.clients.AggregatorClient;
import com.example.jairdev.Report_Microservice.dto.CombinedInfoResponse;
import com.example.jairdev.Report_Microservice.dto.ProductoResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelExportService {

    private final AggregatorClient aggregatorClient;

    public byte[] exportarProductosAExcel(String userId) throws IOException {
        CombinedInfoResponse data = aggregatorClient.getCombinedInfo(userId);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Productos");

        // Estilos
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);
        dataStyle.setAlignment(HorizontalAlignment.CENTER);

        // Fecha y hora
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraExportacion = now.format(formatter);

        // Información del usuario
        Row userRow = sheet.createRow(0);
        userRow.createCell(0).setCellValue("ID del Usuario: " + data.getUsuario().getIdUsuario());
        userRow.createCell(1).setCellValue("Nombre: " + data.getUsuario().getNombreUsuario() + " " + data.getUsuario().getApellidoUsuario());
        userRow.createCell(2).setCellValue("Correo: " + data.getUsuario().getCorreoUsuario());
        userRow.createCell(3).setCellValue("DNI: " + data.getUsuario().getDniUsuario());
        userRow.createCell(4).setCellValue("Teléfono: " + data.getUsuario().getTelefonoUsuario());
        userRow.createCell(5).setCellValue("Rol: " + data.getUsuario().getRol().getNombre());
        userRow.createCell(6).setCellValue("Fecha y Hora de Exportación: " + fechaHoraExportacion);

        // Headers de la tabla
        Row headerRow = sheet.createRow(2);
        String[] headers = {"ID Producto", "Nombre", "Stock", "Precio", "SKU", "Descripción", "Código de Barras", "Categoría", "Estado"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // ✅ CORRECCIÓN: Iterar sobre la lista de productos
        int rowNum = 3;
        List<ProductoResponse> productos = data.getProducto(); // Obtener la lista

        // Validar que la lista no sea nula o vacía
        if (productos != null && !productos.isEmpty()) {
            for (ProductoResponse producto : productos) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(producto.getIdProducto());
                row.createCell(1).setCellValue(producto.getNombreProducto());
                row.createCell(2).setCellValue(producto.getStock());
                row.createCell(3).setCellValue(producto.getPrecio());
                row.createCell(4).setCellValue(producto.getSku());
                row.createCell(5).setCellValue(producto.getDescripcion());
                row.createCell(6).setCellValue(producto.getCodigoBarras());
                row.createCell(7).setCellValue(producto.getCategoria().getNombreCategoria());
                row.createCell(8).setCellValue(producto.getEstado().getNombreEstado());

                // Aplicar estilo a cada celda
                for (int i = 0; i < 9; i++) {
                    row.getCell(i).setCellStyle(dataStyle);
                }
            }
        }

        // Auto-ajustar columnas
        for (int i = 0; i < 9; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        workbook.close();

        return bos.toByteArray();
    }
}