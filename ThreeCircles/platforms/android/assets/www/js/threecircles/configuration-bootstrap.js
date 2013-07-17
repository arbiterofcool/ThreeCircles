var threecircles = threecircles || {};

threecircles.loadConfiguration = (function () {
    threecircles.configuration = {
        //baseURL: "http://localhost:8080/ThreeCircles/",
        //Uncomment for Android emulator localhost
        baseURL: "http://10.0.2.2:8080/ThreeCircles/",
        //Uncomment before pushing to cloudfoundry
        //baseURL: "http://ThreeCircles.cloudfoundry.com/",
        namespace: "threecircles",
        domain:[]
    };
})();

