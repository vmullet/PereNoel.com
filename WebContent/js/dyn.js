$(function(){
	
	$("button[name = 'supprime']").on('click',function()
	{	
		var matable;	
		var row;
		var id=$(this).attr('id');
		
		switch(id)
		{
		case 'nv_produit':
			matable = document.getElementById('tab_produits');
			matable.deleteRow(1);
			$('#admin_aj_nv_produit').prop('disabled',false);
			break;
		case 'nv_client':
			matable = document.getElementById('tab_clients');
			matable.deleteRow(1);
			$('#admin_aj_nv_client').prop('disabled',false);
			break;
		}
		
		$('head script[src*="dyn.js"]').remove();
		$('head script[src*="edit.js"]').remove();
		
	});
	
	$("button[name = 'valide']").on('click',function()
			{	
				var id=$(this).attr('id');
				
				switch(id)
				{
				case 'nv_produit':
					transfert_variable('ajouter_admin_produit','-1');
					var image=document.getElementById("image_produit_hid_-1");
					if (image.value!="")
					$("#form_aj_produit_-1").submit();
					else
						message("myModal","Erreur","Vous n'avez pas sélectionné de photos");
					break;
				case 'nv_client':
					alert('coco');
					transfert_variable('ajouter_admin_client','-1');
					$("#form_aj_client_-1").submit();
					break;
				}
				
				$('head script[src*="dyn.js"]').remove();
				
			});
	

	$('input[type=file]').change(function (event) {
		var id=$(this).attr('data-id');
		
		var select=document.getElementById("select_img_"+id);
		if (select.value!="")
			{
		var img=document.getElementById('img_'+id);
		var tmppath = URL.createObjectURL(event.target.files[0]);
	    img.src=tmppath;
	    img.height = 150;
	    img.width = 120;
	   var v=$("#select_img_"+id).val().replace(/C:\\fakepath\\/i, '');
	  
	   var data = new FormData($('#img_form_'+id)[0]);
	   var hid=document.getElementById("image_produit_hid_"+id);
	  
	   $.ajax({
           
           url: 'Servlet_upload',
           type:'post',
           data:data,
           async: false,
           cache: false,
           contentType: false,
           processData: false,
           success: function () {
           	hid.value="UPLOAD_LOC/"+v;
          
           }
	   });
	   
			}
	});
});