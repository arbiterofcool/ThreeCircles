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