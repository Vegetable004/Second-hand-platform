

(function ($) {
    "use strict";
    var mainApp = {

        main_fun: function () {
           
            var count = new countUp("error-link", 10, 404, 0, 5);

            window.onload = function () {
                        count.start();
            }


        },

        initialization: function () {
            mainApp.main_fun();

        }

    }


    $(document).ready(function () {
        mainApp.main_fun();
    });

}(jQuery));
