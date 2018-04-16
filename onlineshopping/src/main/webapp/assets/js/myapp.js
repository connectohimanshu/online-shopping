$(function(){
	
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
		if(menu==="Home") break;
		$('#listproducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
        
        //code for jquery datatables
        //create a dataset
        
//        var products =[
//                            ['1','ABC'],
//                            ['2','ABC2'],
//                            ['3','ABC3'],
//                            ['4','ABC4'],
//                            ['5','ABC5'],
//                            ['6','ABC6'],
//                            ['7','ABC7'],
//                            ['8','ABC8'],
//                            ['9','ABC9']
//        ];
     
     var $table =$('#productlistTable');
     //execute below code only where we have this table
     
     if($table.length)
     {
//          console.log('Inside this table'); 
          
          var jsonUrl='';
          if(window.categoryId==''){
              jsonUrl = window.contextRoot+ '/json/data/all/products';    
          }else
          {
              jsonUrl = window.contextRoot+ '/json/data/category/'+ window.categoryId +'/products';    
          }
          
          $table.DataTable({
             lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
             pageLength: 5,
             ajax: {
                   url: jsonUrl,
                   dataSrc:''
             },
             columns: [
                 {
                     data: 'name'
                 },
                 {
                     data:'brand'  
                 },
                 {
                     data:'unitPrice',
                     mRender: function(data,type,row){
                         return '&#8377; '+data;
                     }
                 },
                 {
                     data:'quantity'  
                 },
                 {
                     data:'id',
                     bSortable:false,
                     mRender: function(data,type,row){
                         var str='';
                         str +='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary">View</span></a>';
                         str +='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success" style="margin-left: 5px">Add to cart</span></a>';
                         return str;
                     }
                 }
             ]
             
          });
     }
        
        
        
	
});