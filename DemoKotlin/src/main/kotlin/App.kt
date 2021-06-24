package cloud.fastreport.demopdf

import cloud.fastreport.ApiClient
import cloud.fastreport.model.ExportTemplateTaskVM
import cloud.fastreport.model.ExportVM
import cloud.fastreport.model.TemplateCreateVM
import com.google.api.client.http.BasicAuthentication
import java.io.*
import java.util.Base64

object App {

    @JvmStatic
    fun main(args: Array<String>) {
        val defaultClient = ApiClient(
            "https://fastreport.cloud",
            null,
            BasicAuthentication("apikey", "ip7gpezxdd3yowmbqcc751c6kmea919spxb3uwcdaqfcda5er69o"),
            null
        )
        try {

            val root = defaultClient.templatesApi().templateFoldersGetRootFolder(null as String?)

            val bufferedReader: BufferedReader = File("src/Box.frx").bufferedReader()
            val reportFileName = bufferedReader.use { it.readText() }

            val report: String = Base64.getEncoder().encodeToString( reportFileName.toByteArray())

            val template = defaultClient.templatesApi().templatesUploadFile(
                root.id,
                TemplateCreateVM()
                    .name("kotlin.frx")
                    .content(report)
            )
            val exportRoot = defaultClient.exportsApi().exportFoldersGetRootFolder(null as String?)
            var export = defaultClient.templatesApi().templatesExport(
                template.id,
                ExportTemplateTaskVM()
                    .fileName("kotlin.pdf")
                    .format(ExportTemplateTaskVM.FormatEnum.PDF)
                    .folderId(exportRoot.id)
                    .pagesCount(999)
            )

            // wait until status ready
            while (export.status != ExportVM.StatusEnum.SUCCESS) {
                export = defaultClient.exportsApi().exportsGetFile(export.id)
                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            val response = defaultClient.downloadApi().downloadGetExportForHttpResponse(export.id)
            BufferedInputStream(response.content).use { `in` ->
                FileOutputStream("kotlin.pdf").use { fileOutputStream ->
                    val dataBuffer = ByteArray(1024)
                    var bytesRead: Int
                    while (`in`.read(dataBuffer, 0, 1024).also { bytesRead = it } != -1) {
                        fileOutputStream.write(dataBuffer, 0, bytesRead)
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}