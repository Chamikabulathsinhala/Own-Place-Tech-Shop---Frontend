async function  checkSignIn() {
    const  response = await fetch(
            "CheckSignIn"
            );
    if (response.ok) {
        const json = await response.json();
        if (json.success) {
            const user = json.content;
            console.log(user);

        }


    } else {
        //not signed
        console.log("Not signed in");
    }
}

