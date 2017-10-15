$(window).load(function() {
		// Animate loader off screen
		$(".se-pre-con").fadeOut("slow");;
	});

$('.btn-number').click(function(e){
    e.preventDefault();
    
    fieldName = $(this).attr('data-field');
    type      = $(this).attr('data-type');
    var input = $("input[name='"+fieldName+"']");
    var currentVal = parseInt(input.val());
    if (!isNaN(currentVal)) {
        if(type == 'minus') {
            
            if(currentVal > input.attr('min')) {
                input.val(currentVal - 1).change();
            } 
            if(parseInt(input.val()) == input.attr('min')) {
                $(this).attr('disabled', true);
            }

        } else if(type == 'plus') {

            if(currentVal < input.attr('max')) {
                input.val(currentVal + 1).change();
            }
            if(parseInt(input.val()) == input.attr('max')) {
                $(this).attr('disabled', true);
            }

        }
    } else {
        input.val(0);
    }
});
$('.input-number').focusin(function(){
   $(this).data('oldValue', $(this).val());
});
$('.input-number').change(function() {
    
    minValue =  parseInt($(this).attr('min'));
    maxValue =  parseInt($(this).attr('max'));
    valueCurrent = parseInt($(this).val());
    
    name = $(this).attr('name');
    if(valueCurrent >= minValue) {
        $(".btn-number[data-type='minus'][data-field='"+name+"']").removeAttr('disabled')
    } else {
        message("myModal","Erreur","Valeur incorrecte !<br>Minimum autorisé : "+minValue);
        $(this).val($(this).data('oldValue'));
    }
    if(valueCurrent <= maxValue) {
        $(".btn-number[data-type='plus'][data-field='"+name+"']").removeAttr('disabled')
    } else {
    	message("myModal","Erreur","Valeur incorrecte !<br>Maximum autorisé : "+maxValue);
        $(this).val($(this).data('oldValue'));
    }
    
    
});
$(".input-number").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
             // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) || 
             // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });

function dynamic_div(p_page)
{
	
	$('#container_jsp').fadeOut('fast',function(){
	    $('#container_jsp').load("fragments/"+p_page+".jsp", function(){
	    	$(".se-pre-con").fadeIn('fast');
	    	$('#container_jsp').fadeIn('fast');
	    	$(".se-pre-con").fadeOut('fast');
	    });
	});
	
	$('html, body').animate({ scrollTop: $('#container_jsp').offset().top }, 'slow');
	var interaction= document.getElementById("interaction");
	if (interaction!=null)
		{
	if (interaction.value!="")
		interaction.value="";
		}
				
}

$(function()
		
{
	$('[data-toggle="confirmation"]').confirmation({
		
		singleton: true,
		onConfirm:function(){
			
		var id =$(this).attr('id');
		
		if (id==-1)
			{
			$("#form_vide_panier").submit();
			}
		else
			{
	$("#form_"+id).submit();
			}
		
	}

	});	
	$('[data-mode="modif_client"]').click(function(event) {
		var id =$(this).attr('data-id');
		transfert_variable('modif_client',id);
		$("#form_mod_"+id).submit();
	})
	
	$('[data-mode="modif_produit"]').click(function(event) {
		var id =$(this).attr('data-id');
		transfert_variable('modif_produit',id);
		$("#form_mod_"+id).submit();
	})
	
	
	
	var interaction= document.getElementById("interaction");
	if (interaction!=null)
		{
	switch(interaction.value)
	{
	case "panier":
		dynamic_div('panier');
		break;
		
	case "login":
		dynamic_div('login');
		break;
		
	case "register":
		dynamic_div('login');
		break;
		
	case "gestion_client":
		dynamic_div('gestion_client');
		break;
		
	case "gestion_produit":
		dynamic_div('gestion_produit');
		break;
		
	case "modif_profil":
		dynamic_div('client_infos');
		break;
		
	case "confirm":
		dynamic_div('confirm');
		break;
		
	case "step_order":
		dynamic_div('step_order');
		break;
	case "client_commandes":
		dynamic_div('client_commandes');
		break;
	
		
		
	}
		}		
		
	$("#btn_modif_cl_pass").on('click',function(event)		
			{
			var pass=document.getElementById("nv_pass");
			var pass_confirm=document.getElementById("nv_pass_confirm");
			
				if (pass.value!=pass_confirm.value)
					{
					message("myModal","Erreur","Les mots de passe ne correspondent pas");
					}
				else
					{
					if (pass.value.length>5)
						$("#form_modif_cl_pass").submit();
					else
						message("myModal","Erreur","Mot de passe trop court (minimum: 5 caractères)");
					}
			});
	
	
	$('input[type=file]').change(function (event) {
		var id=$(this).attr('data-id');
		
		var select=document.getElementById("select_img_"+id);
		
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
	   
	});
		
}

);


/*
 * 
 * STEP ORDER--------------------------------------------
 */
function transfert_variable(mode,id)
{
	switch(mode)
	{
	case "modif_client":
		var adresse=document.getElementsByName("adresse_"+id);
		var cp=document.getElementsByName("cp_"+id);
		var ville=document.getElementsByName("ville_"+id);
		var tel=document.getElementsByName("tel_"+id);
		var mail=document.getElementsByName("mail_"+id);
		var login=document.getElementsByName("login_"+id);
		var pass=document.getElementsByName("pass_"+id);
		var pass_confirm=document.getElementsByName("pass_confirm_"+id);
		var admin=document.getElementsByName("admin_"+id);
		var adresse_hid=document.getElementsByName("adresse_hid_"+id);
		var cp_hid=document.getElementsByName("cp_hid_"+id);
		var ville_hid=document.getElementsByName("ville_hid_"+id);
		var tel_hid=document.getElementsByName("tel_hid_"+id);
		var mail_hid=document.getElementsByName("mail_hid_"+id);
		var login_hid=document.getElementsByName("login_hid_"+id);
		var pass_hid=document.getElementsByName("pass_hid_"+id);
		var admin_hid=document.getElementsByName("admin_hid_"+id);
		adresse_hid[0].value=adresse[0].value;
		cp_hid[0].value=cp[0].value;
		ville_hid[0].value=ville[0].value;
		tel_hid[0].value=tel[0].value;
		mail_hid[0].value=mail[0].value;
		login_hid[0].value=login[0].value;
		pass_hid[0].value=pass[0].value;
		admin_hid[0].value=admin[0].value;
		break;
		
	case "modif_produit":
	case "ajouter_admin_produit":
		var libelle=document.getElementsByName("libelle_"+id);
		var description=document.getElementsByName("description_"+id);
		var prix=document.getElementsByName("prix_"+id);
		var stock=document.getElementsByName("stock_"+id);
		
		var libelle_hid=document.getElementsByName("libelle_produit_hid_"+id);
		var description_hid=document.getElementsByName("description_produit_hid_"+id);
		var prix_hid=document.getElementsByName("prix_produit_hid_"+id);
		var stock_hid=document.getElementsByName("stock_produit_hid_"+id);
		
		libelle_hid[0].value=libelle[0].value;
		description_hid[0].value=description[0].value;
		prix_hid[0].value=prix[0].value;
		stock_hid[0].value=stock[0].value;
		
		break;
	
	case "ajouter_admin_client":
		var nom=document.getElementsByName("nom_-1");
		var prenom=document.getElementsByName("prenom_-1");
		var nom_hid=document.getElementsByName("nom_hid_-1");
		var prenom_hid=document.getElementsByName("prenom_hid_-1");
		nom_hid[0].value=nom[0].value;
		prenom_hid[0].value=prenom[0].value;
		transfert_variable('modif_client','-1');
		break;
		
	}
	
}

function message(id,type,contenu){
	$("#"+id+"").find('h4').html(type);  
	$("#"+id+"").find('p').html('<span style="color:#4F2817;">'+contenu);  
	$("#"+id+"").modal();
}