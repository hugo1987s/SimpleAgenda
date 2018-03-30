package presentacion.reportes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import dto.PersonaDTO;
import dto.ReporteDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteAgenda
{
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint reporteLleno;

	// Recibe la lista de personas para armar el reporte
	public ReporteAgenda(List<PersonaDTO> personas)
	{
		// Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha",
				new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		try
		{

			this.reporte = (JasperReport) JRLoader
					.loadObjectFromFile("reportes\\ReporteAgenda.jasper");
			this.reporteLleno = JasperFillManager.fillReport(this.reporte,
					parametersMap, new JRBeanCollectionDataSource(personas));
		} catch (JRException ex)
		{
			ex.printStackTrace();
		}
	}

	public ReporteAgenda(List<PersonaDTO> personas, String nombreReporte,
			Map<String, Object> parametersMap)
	{
		try
		{

			// this.reporte = (JasperReport) JRLoader.loadObjectFromFile(
			// "reportes\\" + nombreReporte + ".jasper" );
			this.reporte = (JasperReport) JRLoader
					.loadObjectFromFile(getPropertyValue(nombreReporte));
			this.reporteLleno = JasperFillManager.fillReport(this.reporte,
					parametersMap, new JRBeanCollectionDataSource(personas));
		} catch (JRException ex)
		{
			ex.printStackTrace();
		}
	}

	public ReporteAgenda(List<ReporteDTO> personas, String nombreReporte,
			Map<String, Object> parametersMap, boolean valor)
	{

		try
		{

			// this.reporte = (JasperReport) JRLoader.loadObjectFromFile(
			// "reportes\\" + nombreReporte + ".jasper" );
			this.reporte = (JasperReport) JRLoader
					.loadObjectFromFile(getPropertyValue(nombreReporte));
			this.reporteLleno = JasperFillManager.fillReport(this.reporte,
					parametersMap, new JRBeanCollectionDataSource(personas));
		} catch (JRException ex)
		{
			ex.printStackTrace();
		}
	}

	private String getPropertyValue(String propertyKey)
	{
		Properties p = new Properties();
		try
		{
			p.load(new FileReader("Configuracion\\config.properties"));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return "";
		} catch (IOException e)
		{

			e.printStackTrace();
			return "";
		}
		return p.getProperty(propertyKey);
	}

	public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno, false);
		this.reporteViewer.setVisible(true);
	}

}