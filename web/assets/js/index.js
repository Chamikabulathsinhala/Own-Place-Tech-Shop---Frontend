async function checkSignIn() {

    const response = await fetch("CheckSignIn");

    if (response.ok) {

        const json = await response.json();

        const response_DTO = json.response_DTO;

        if (response_DTO.success) {

            //sign in
            const user = response_DTO.content;

            let st_quick_link = document.getElementById("st-quick-link");

            let st_quick_link_li_1 = document.getElementById("st-quick-link-li-1");
            let st_quick_link_li_2 = document.getElementById("st-quick-link-li-2");
            st_quick_link_li_1.remove();
            st_quick_link_li_2.remove();

            let new_li_tag1 = document.createElement("li");
            let new_li_a_tag = document.createElement("a");
            new_li_a_tag.href = "#";
            new_li_tag1.innerHTML = user.first_name + " " + user.last_name;
            st_quick_link.appendChild(new_li_tag1);
            new_li_tag1.appendChild(new_li_a_tag);

            let st_button_1 = document.getElementById("st-button-1");
            st_button_1.href = "SignOut";
            st_button_1.innerHTML = "Sign Out";

            let st_div_1 = document.getElementById("st-div-1");
            st_div_1.remove();
        } else {
            console.log("signed");
            //not signed in

        }

        const productList = json.products;

        let i = 1;
        productList.forEach(product => {
            document.getElementById("st-product-title-" + i).innerHTML = product.title;
            document.getElementById("st-product-link-" + i).href = "single-product.html?id=" + product.id;
            document.getElementById("st-product-image-" + i).src = "product-images/" + product.id + "/image1.png";
            document.getElementById("st-product-price-" + i).innerHTML = new Intl.NumberFormat(
                    "en-US",
                    {
                        minimumFractionDigits: 2
                    }
            ).format((product.price));
            i++;
        });



    }

}

async function viewCart() {

    const response = await fetch("cart.html");

    if (response.ok) {

        const cartHtmlText = await response.text();

        const parser = new DOMParser();
        const cartHtml = parser.parseFromString(cartHtmlText, "text/html");

        const cart_main = cartHtml.querySelector(".main-wrapper");

        document.querySelector(".main-wrapper").innerHTML = cart_main.innerHTML;

        loadCartItems();

    }

}

async function c_Product_load() {
    const response = await fetch(
            "HomeProduct"

            );
    if (response.ok) {
        const json = await response.json();

        const  products = json.productList;
        
        let c_product = document.getElementById("c-product");
        document.getElementById("c-product-main").innerHTML = "";
        
        products.forEach(item => {
            let cartItemRowClone = c_product.cloneNode(true);

            cartItemRowClone.querySelector("#c-product-image").src = "product-images/" + item.id + "/image1.png";
             cartItemRowClone.querySelector("#c-product-a1").href = "single-product.html?id=" + item.id;
             cartItemRowClone.querySelector("#c-price").innerHTML = item.price;
             cartItemRowClone.querySelector("#c-title").innerHTML = item.title;
           

            document.getElementById("c-product-main").appendChild(cartItemRowClone);
        });
    } else {

    }
}