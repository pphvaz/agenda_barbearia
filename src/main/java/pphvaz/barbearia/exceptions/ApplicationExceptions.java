package pphvaz.barbearia.exceptions;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pphvaz.barbearia.dto.ObjetoErroDto;

/* INTERCEPTA OS ERROS DO PROJETO */

@RestControllerAdvice
@ControllerAdvice
public class ApplicationExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomExceptions.class)
	public ResponseEntity<Object> handleExceptionCustom(CustomExceptions ex) {

		ObjetoErroDto objetoErro = new ObjetoErroDto();

		objetoErro.setError(ex.getMessage());
		objetoErro.setCode(HttpStatus.OK.toString());

		return new ResponseEntity<Object>(objetoErro, HttpStatus.OK);

	}

	/* CAPTURA EXCECOES DO PROJETO */
	@ExceptionHandler({ Exception.class, RuntimeException.class, Throwable.class })
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ObjetoErroDto objetoErro = new ObjetoErroDto();

		String msg = "";

		if (ex instanceof MethodArgumentNotValidException) {
			List<ObjectError> list = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();

			for (ObjectError objectError : list) {
				msg += objectError.getDefaultMessage() + "\n";
			}
		}
		if (ex instanceof HttpMessageNotReadableException) {
			msg = "Não está sendo enviado dados para o BODY (corpo da requisição";
		} else {
			msg = ex.getMessage();
			ex.printStackTrace();
		}

		objetoErro.setError(msg);
		objetoErro.setCode(status.value() + "==>" + status.getReasonPhrase());

		return new ResponseEntity<Object>(objetoErro, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/* CAPTURA ERROS DE BANCO DE DADOS */
	@ExceptionHandler({ DataIntegrityViolationException.class, ConstraintViolationException.class, SQLException.class })
	protected ResponseEntity<Object> handleExceptionDataIntegrity(Exception ex) {

		ObjetoErroDto objetoErroDto = new ObjetoErroDto();

		String msg = "";

		if (ex instanceof SQLException) {

			msg = "Erro de SQL do banco: " + ((SQLException) ex).getCause().getCause().getMessage();

		} else if (ex instanceof DataIntegrityViolationException) {

			msg = "Erro de integridade do banco: "
					+ ((DataIntegrityViolationException) ex).getCause().getCause().getMessage();

		} else if (ex instanceof ConstraintViolationException) {

			msg = "Erro de chave estrangeira: "
					+ ((ConstraintViolationException) ex).getCause().getCause().getMessage();

		}

		objetoErroDto.setError(msg);
		objetoErroDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());

		return new ResponseEntity<Object>(objetoErroDto, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
}
