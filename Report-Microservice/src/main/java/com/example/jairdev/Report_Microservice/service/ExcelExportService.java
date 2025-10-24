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
    public byte[] exportarProductosAExcel(String userId,String productId) throws IOException {
        CombinedInfoResponse data = aggregatorClient.getCombinedInfo(userId, productId);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Productos");

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

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraExportacion = now.format(formatter);

        Row userRow = sheet.createRow(0);
        userRow.createCell(0).setCellValue("ID del Usuario: " + data.getUsuario().getIdUsuario());
        userRow.createCell(1).setCellValue("Nombre: " + data.getUsuario().getNombreUsuario() + " " + data.getUsuario().getApellidoUsuario());
        userRow.createCell(2).setCellValue("Correo: " + data.getUsuario().getCorreoUsuario());
        userRow.createCell(3).setCellValue("DNI: " + data.getUsuario().getDniUsuario());
        userRow.createCell(4).setCellValue("Teléfono: " + data.getUsuario().getTelefonoUsuario());
        userRow.createCell(5).setCellValue("Rol: " + data.getUsuario().getRol().getNombre());
        userRow.createCell(6).setCellValue("Fecha y Hora de Exportación: " + fechaHoraExportacion);

        Row headerRow = sheet.createRow(2);
        String[] headers = {"ID Producto", "Nombre", "Stock", "Precio", "SKU", "Descripción", "Código de Barras", "Categoría", "Estado"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        int rowNum = 3;

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.getProducto().getIdProducto());
            row.createCell(1).setCellValue(data.getProducto().getNombreProducto());
            row.createCell(2).setCellValue(data.getProducto().getStock());
            row.createCell(3).setCellValue(data.getProducto().getPrecio());
            row.createCell(4).setCellValue(data.getProducto().getSku());
            row.createCell(5).setCellValue(data.getProducto().getDescripcion());
            row.createCell(6).setCellValue(data.getProducto().getCodigoBarras());
            row.createCell(7).setCellValue(data.getProducto().getCategoria().getNombreCategoria());
            row.createCell(8).setCellValue(data.getProducto().getEstado().getNombreEstado());

            for (int i = 0; i < 9; i++) {
                row.getCell(i).setCellStyle(dataStyle);
            }


        for (int i = 0; i < 9; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        workbook.close();

        return bos.toByteArray();
    }
}