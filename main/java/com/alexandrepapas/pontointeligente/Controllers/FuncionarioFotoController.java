package com.alexandrepapas.pontointeligente.Controllers;

import com.alexandrepapas.pontointeligente.Entities.FotoFuncionario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("/funcionarios/{funcionarioId}/foto")
public class FuncionarioFotoController {
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void atualizarFoto(@PathVariable Long funcionarioId, FotoFuncionario fotoFuncionario){

        var nomerArquivo = UUID.randomUUID().toString()+"_"+ fotoFuncionario.getArquivo().getOriginalFilename();

        var arquivoFoto= Path.of("C:\\Users\\papas\\Desktop\\fotos", nomerArquivo);

        System.out.println(fotoFuncionario.getDescricao());
        System.out.println(arquivoFoto);
        System.out.println(fotoFuncionario.getArquivo().getContentType());

        try {
            fotoFuncionario.getArquivo().transferTo(arquivoFoto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
