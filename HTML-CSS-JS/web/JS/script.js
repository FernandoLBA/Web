$(document).ready(function(){
	//ponemos nuestro código JavaScript que utiliza jQuery
	//el simbolo $ se usa para seleccionar un elemento de la página web

	//llamamos a la función que selecciona el enlace de la página donde nos encontramos
	configurarInicio();

	$('.myicono').click(function(e){//se llama a la clase myicono, en el evento click, llama ala función y le pasa el parámetro e.
		//console.dir(e);//muestra el parametro por consola
		//alert('Prueba');//muestra una alerta con la palabra Prueba

		//aqui usamos el elemento navbar/ul y luego llamamos a la clase lista-sm que pertenece a la lista ul, para mostrar el menú cuando estemos usando un móvil.
		$('#navbar ul').toggleClass('lista-sm');
	})

	//esta función permite indicar a página donde nos encontramos actualmente y seleccionar el enlace del menú correspondiente al sitio.
	function configurarInicio(){
		//asignamos a una variable la ruta dónde nos encontramos
		var urlPath = window.location.pathname;
		//imprime la ruta
		console.log(urlPath);
		//recorre los enlaces del nav y los muestra por consola
		$('nav a').each(function(){
			//asigna a href el atributo href de cada enlace y lo imprime por consola
			var href = $(this).attr('href');
			console.log(href);
			var indice = urlPath.length - href.length;
			//console.log(indice);
			console.log(urlPath.substring(indice));
			if(urlPath.substring(indice) === href){
				console.log('Match');
				$(this).closest('li').addClass('active');
			}
		})
	}
})


