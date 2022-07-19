use e_comm_app;
db.createCollection("customer");
db.customer.insert([{
    c_id:1, c_name:"Jacob", c_addr:"New York",total_amount:200},
    {c_id:2, c_name:"David", c_addr:"Sans Fran",total_amount:2300},
    {c_id:3, c_name:"John", c_addr:"Chicago",total_amount:2300},
    {c_id:4, c_name:"Snow", c_addr:"California",total_amount:1200},
    {c_id:5, c_name:"Ankit", c_addr:"Ottawa",total_amount:2100},
    {c_id:6, c_name:"Ankita", c_addr:"Montreal",total_amount:2200},
    {c_id:7, c_name:"Jani", c_addr:"Rome",total_amount:2001},
    {c_id:8, c_name:"Trek", c_addr:"Greece",total_amount:20},
    {c_id:9, c_name:"Shrek", c_addr:"Pakistan",total_amount:1},
    {c_id:10, c_name:"Breda", c_addr:"India",total_amount:2000},
    ]);

    db.customer.find().sort({total_amount:-1}).limit(3)
    db.customer.find().sort({"c_name":-1})
    db.customer.find({"total_amount":{$gt:10,$lt:200}})


