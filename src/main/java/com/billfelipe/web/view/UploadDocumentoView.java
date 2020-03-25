package com.billfelipe.web.view;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.billfelipe.glasgow.framework.View;
import com.billfelipe.glasgow.model.Documento;
import com.billfelipe.service.DocumentoService;

@Model
public class UploadDocumentoView extends View implements Serializable {

	private UploadedFile file;

	@Inject
	private DocumentoService documentoService;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void importar(FileUploadEvent event) {
		if (event == null || event.getFile() == null) {
			pushMessage("Nenhum arquivo foi selecionado");
			return;
		}
		Documento documento = new Documento();
		documento.setNome(event.getFile().getFileName());
		documento.setContentType(event.getFile().getContentType());
		documento.setArquivo(event.getFile().getContents());
		documentoService.cadastrar(documento);
		pushMessage(event.getFile().getFileName() + " importado com sucesso");
	}
}
