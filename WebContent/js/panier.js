$(function()
		{
	$('[data-mode="quantite_panier"]').bind('keyup change',function(event) {
		
		var id =$(this).attr('data-id');
		
		var quantite=document.getElementById('pan_qte_'+id);
		if (quantite.value!="")
			{
		if (parseInt(quantite.value)>parseInt($(this).attr('max')))
			{
			message("myModal","Erreur","Valeur incorrecte<br>Maximum autorisé: "+$(this).attr('max')+'</span>');
			quantite.value=$(this).attr('max');
			}
		if (parseInt(quantite.value)<parseInt($(this).attr('min')))
		{
			message("myModal","Erreur","Valeur incorrecte<br>Minimum autorisé: "+$(this).attr('min')+'</span>');
		    quantite.value=$(this).attr('min');
		}
		var prix=document.getElementById('px_prod_'+id).innerHTML;
		var sous_total=document.getElementById('pan_ss_'+id);
		var total=parseInt(quantite.value)*prix;
		
		sous_total.innerHTML=(parseInt(quantite.value)*prix);
		var ss_totaux=document.getElementsByName('ss_totaux');
		var tt_panier=document.getElementById('total_panier');
		var total_panier=0;
		for (var i=0;i<ss_totaux.length;i++)
			{
			total_panier=total_panier+parseFloat(ss_totaux[i].innerHTML);
			
			}
		tt_panier.innerHTML="<strong>Total: "+total_panier+" &euro;</strong>";
		
		var frm = $('#ajax_quantite_'+id);
		
	        $.ajax({
	            
	            url: 'Servlet_panier',
	            data: frm.serialize(),
	            success: function () {
	            	
	            }
	        })
     
			}		
	})
		});

function message(id,type,contenu){
	$("#"+id+"").find('h4').html(type);  
	$("#"+id+"").find('p').html('<span style="color:#4F2817;">'+contenu);  
	$("#"+id+"").modal();
}