$(function(){
	
	//solving the active menu problem
	switch (menu) {
	
	case 'About':
		$('#about').addClass('active');
		break;

	case 'Contact':
		$('#contact').addClass('active');
		break;
		
	case 'View Products':
		$('#listproducts').addClass('active');
		break;
		
	default:
		$('#listproducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
});