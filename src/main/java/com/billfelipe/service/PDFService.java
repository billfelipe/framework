package com.billfelipe.service;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.billfelipe.glasgow.model.Prova;

public class PDFService {

	public PDDocument obterPDDocument(final Prova prova) throws IOException {
		return PDDocument.load(prova.getDocumento().getArquivo());
	}
	
	public String extrairConteudoDoArquivo(final Prova prova) throws IOException {
		PDDocument pdDocument = obterPDDocument(prova);
		PDFTextStripper stripper = new PDFTextStripper();
		String conteudo = stripper.getText(pdDocument);
		pdDocument.close();
		return conteudo;
	}

	public void removerPrimeirasPaginas(PDDocument pdDocument, int quantidadeDePaginasParaRemover) {
		while (quantidadeDePaginasParaRemover > 0) {
			pdDocument.removePage(0);
			quantidadeDePaginasParaRemover--;
		}
	}

	public void removerUltimasPaginas(PDDocument pdDocument, int quantidadeDePaginasParaRemover) {
		while (quantidadeDePaginasParaRemover > 0) {
			pdDocument.removePage(pdDocument.getNumberOfPages() - 1);
			quantidadeDePaginasParaRemover--;
		}
	}

}
