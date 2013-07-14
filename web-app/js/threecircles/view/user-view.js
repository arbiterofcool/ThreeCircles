var threecircles = threecircles || {};
threecircles.view = threecircles.view || {};

threecircles.view.userview = function (model, elements) {

    var that = grails.mobile.mvc.view(model, elements);

    that.init = function () {
        that.listButtonClicked.notify();
    };


    // Register events
    that.model.listedItems.attach(function (data) {
        $('#list-user').empty();
        var key, items = model.getItems();
        $.each(items, function(key, value) {
            renderElement(value);
        });
        $('#list-user').listview('refresh');
    });

     // user interface actions
    that.elements.list.on('pageinit', function (e) {
        that.listButtonClicked.notify();
    });

    var show = function(dataId, event) {
        event.stopPropagation();
        $('#form-update-user').validationEngine('hide');
        $('#form-update-user').validationEngine({promptPosition: 'bottomLeft'});
        showElement(dataId);
        that.editButtonClicked.notify(function () {
            showDependentElement(dataId);
        });
    };

    var createElement = function () {
        resetForm('form-update-user');
        $.mobile.changePage($('#section-show-user'));
        $('#delete-user').css('display', 'none');
        that.editButtonClicked.notify(function () {
        });
    };

    var showElement = function (id) {
        resetForm('form-update-user');
        showDependentElement(id);
        var element = that.model.items[id];
        $.each(element, function (name, value) {
            var input = $('#input-user-' + name);
            if (input.attr('type') != 'file') {
                input.val(value);
            } else {
                if (value) {
                    var img = grails.mobile.camera.encode(value);
                    input.parent().css('background-image', 'url("' + img + '")');
                    input.attr('data-value', img);
                }
            }
            if (input.attr('data-type') == 'date') {
                input.scroller('setDate', (value === '') ? '' : new Date(value), true);
            }
        });
        $('#delete-user').show();
        $.mobile.changePage($('#section-show-user'));
    };

    var showDependentElement = function (id) {
        var element = that.model.items[id];
        var friendsSelected = element.friends;
        $.each(friendsSelected, function (key, value) {
            var selector;
            if (value === Object(value)) {
                selector= '#checkbox-friends-' + value.id;
            } else {
                selector= '#checkbox-friends-' + value;
            }
            $(selector).attr('checked','checked').checkboxradio('refresh');
        });
    }

    var resetForm = function (form) {
        $('input[data-type="date"]').each(function() {
            $(this).scroller('destroy').scroller({
                preset: 'date',
                theme: 'default',
                display: 'modal',
                mode: 'scroller',
                dateOrder: 'mmD ddyy'
            });
        });
        var div = $("#" + form);
        if(div) {
            if (div[0]) {
                div[0].reset();
            }
            $.each(div.find('input:hidden'), function(id, input) {
                if ($(input).attr('type') != 'file') {
                    $(input).val('');
                } else {
                    $(input).parent().css('background-image', 'url("images/camera.png")');
                    $(input).attr('data-value', '');
                }
            });
        }
    };

    var createListItem = function (element) {
        var li, a = $('<a>');
        var img = $('<img>');
        img.attr({
            src: 'img/friend.jpg'
        });
        a.attr({
            id : 'user-list-' + element.id,
            'data-id' : element.id,
            'data-transition': 'fade'
        });
        a.append(img);
        a.append(getText(element));
        a.on('vclick', function(event) {
            show(element.id, event);
        });
        
        if (element.offlineStatus === 'NOT-SYNC') {
            li =  $('<li>').attr({'data-theme': 'e'});
            li.append(a);
        } else {
            li = $('<li>').append(a);
        }
        return li;
    };

    var renderElement = function (element) {
        $('#list-user').append(createListItem(element));
    };

    var getText = function (data) {
        var textDisplay = data.firstname + " " + data.lastname;
        return textDisplay
    };

    return that;
};