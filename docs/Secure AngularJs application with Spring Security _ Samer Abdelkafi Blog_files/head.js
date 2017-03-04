window.__ATA = {
        scriptSrc: '//s.pubmine.com/showad.js',
        slotPrefix: 'automattic-id-',
        passbackReceiver: 'automattic-passback-receiver',
        passbackSrc: '//s.pubmine.com/passback.html',
        customParams: _ipw_custom,
        providerData: [],
        initAd: function(o){
                var o=o||{},g=window,d=g.document,wr=d.write,id=g.__ATA.id();wr.call(d,
                '<div id="'+id+'" data-section="'+(o.sectionId||0)+'"'+(o.type?('data-type="'+o.type+'"'):'')+' '+(o.forcedUrl?('data-forcedurl="'+o.forcedUrl+'"'):'')+' style="width:'+(o.width||0)+'px; height:'+(o.height||0)+'px;">');g.__ATA.displayAd(id, o.customParams);wr.call(d,'</div>');
        },
        displayAd: function(id){window.__ATA.ids=window.__ATA.ids||{};window.__ATA.ids[id]=1;},
        registerAdapterResult: function(id, result, time){if ("undefined" != typeof result && null !== result) {window.__ATA.providerData.push({'provider': id, 'response': result, 'responsetime': time || ''})}},
        id: function(){return window.__ATA.slotPrefix+(parseInt(Math.random()*10000,10)+1+(new Date()).getMilliseconds());}
};

//headerbidding
(function(showadName){
    if (!window[showadName]) return;

    function loadScript(src, cb) {
        var s = document.createElement('script');
        var isReady = false;
        function onReady(e){
            isReady = true;
            s.removeEventListener('load', onReady);
            s.removeEventListener('error', onReady);
            s.parentElement.removeChild(s);
            cb && cb(e && e.type === 'load');
        }
        s.setAttribute('type','text/javascript');
        s.addEventListener('load', onReady);
        s.addEventListener('error',onReady);
        s.setAttribute('src', src);
        var p = document.head || document.body;
        p.appendChild(s);
        return function(ignoreCb){
            if (isReady) return;
            if (ignoreCb) {
                cb = false;
            }
            onReady(false);
        };
    }

    var providers = [
        function(done){
            window.ybotq = window.ybotq || [];
            loadScript('//cdn.yldbt.com/js/yieldbot.intent.js', function(){
                /*loadScript('http://i.yldbt.com/m/1234/v1/init?cb=yieldbot.updateState&v=v2015-06-23%7Ce14513e&vi=ize3kkg18czrr00z20&si=ize3kkg217kyjpgli2&pvi=ize3kkg10mq9wn5k21&pvd=1&nv&sn=test_slot_320x50&ssz=&lo=http%3A//dominica/tmp.html&r=&sd=1280x800&to=-3&la=ru&np=MacIntel&ua=Mozilla/5.0%20%28Macintosh%3B%20Intel%20Mac%20OS%20X%2010_11_6%29%20AppleWebKit/537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome/55.0.2883.95%20Safari/537.36&cts_ns=1487594854277&cts_js=1487594860405&cts_ini=1487594860422&e',function(){
                     done('YB', yieldbot.getPageCriteria());
                 });*/
                /*ybotq.push(function () {
                     yieldbot.pub('1234');
                     //yieldbot.enableAsync();
                     yieldbot.go();
                 });
                 ybotq.push(function () {*/
                done('YB', yieldbot.getPageCriteria());
                //});
            });
        },
        function(done){
            loadScript('//c.amazon-adsystem.com/aax2/amzn_ads.js', function(){
                try {
                    amznads.getAdsCallback("3033", function(){
                        done('A9', amznads.getKeys());
                    });
                } catch (err) {}
            });
        }
    ];

    try {
        new Promise();
    } catch(err) {
        function Promise(fn) {
            this.PromiseState = 'pending';
            this.PromiseResult = undefined;
            this.PromiseFulfillReactions = [];
            this.PromiseRejectReactions = [];
            this._full_prms = [];
            this._rej_prms = [];
            var p = this;
            function next(res) {
                try {
                    var i, l;
                    if (res instanceof Promise) {
                        if (res.PromiseState === 'pending') {
                            for (i= 0,l=p.PromiseFulfillReactions.length;i<l;i++) {
                                res._full_prms.push(p._full_prms[i]);
                                res.PromiseFulfillReactions.push(p.PromiseFulfillReactions[i]);
                            }
                            for (i= 0,l=p.PromiseRejectReactions.length;i<l;i++) {
                                res._rej_prms.push(p._rej_prms[i]);
                                res.PromiseRejectReactions.push(p.PromiseRejectReactions[i]);
                            }
                            return;
                        } else {
                            res = res.PromiseResult;
                        }
                    }
                    for (i= 0,l=p.PromiseFulfillReactions.length;i<l;i++) {
                        p._full_prms[i]._run(p.PromiseFulfillReactions[i], res);
                    }
                } catch(err){}
            }
            function rej(err) {
                for (i= 0,l=p.PromiseRejectReactions.length;i<l;i++) {
                    p._rej_prms[i]._run(p.PromiseRejectReactions[i], err);
                }
            }
            if (fn) {
                fn(function(res){
                    if (p.PromiseState !== 'pending') return;
                    p.PromiseState = 'resolved';
                    p.PromiseResult = res;
                    next(res);
                }, function(err){
                    if (p.PromiseState !== 'pending') return;
                    p.PromiseState = 'rejected';
                    p.PromiseResult = err;
                    rej(err)
                });
            } else {
                this._run = function(fn, res){
                    if (p.PromiseState !== 'pending') return;
                    try {
                        p.PromiseState = 'resolved';
                        p.PromiseResult = fn(res);
                        next(p.PromiseResult);
                    } catch(err) {
                        p.PromiseState = 'rejected';
                        p.PromiseResult = err;
                        rej(err);
                    }
                };
            }
        }
        Promise.prototype = {
            then: function(fn,rej){
                var p = (fn || rej) && new Promise();
                if (fn) {
                    this._full_prms.push(p);
                    this.PromiseFulfillReactions.push(fn);
                }
                if (rej) {
                    this._rej_prms.push(p);
                    this.PromiseRejectReactions.push(rej);
                }
                if (this.PromiseState === 'resolved') {
                    fn && p._run(fn, this.PromiseResult);
                } else if (this.PromiseState === 'rejected') {
                    rej && p._run(rej, this.PromiseResult);
                }
                return p;
            }
        };
        Promise.all = function(list){
            return new Promise(function(done, fall){
                var num = 0, fullRes = [];
                function check(res){
                    fullRes.push(res);
                    num --;
                    if (!num) {
                        done(fullRes);
                    }
                }
                for (var i=0,l=list.length; i<l; i++) {
                    if (list[i] instanceof Promise) {
                        num ++;
                        list[i].then(check,fall);
                    }
                }
            });
        };
        Promise.resolve = function(val){
            var p = new Promise();
            delete p._run;
            p.PromiseState = 'resolved';
            p.PromiseResult = val;
            return p;
        };
        Promise.reject = function(err){
            var p = new Promise();
            delete p._run;
            p.PromiseState = 'rejected';
            p.PromiseResult = err;
            return p;
        }
    }

    try {
        var list = [];
        for (var i = 0, l = providers.length; i < l; i++) {
            list.push(new Promise((function (pInit) {
                return function (done) {
                    try {
                        var doneReady;
                        var timer = setTimeout(function(){if (!doneReady) {doneReady = true; done();}}, 3000);
                        var now = +new Date();
                        pInit(function (name, res) {
                            try {
                                clearTimeout(timer);
                                window[showadName].registerAdapterResult(name, res, new Date - now);
                                doneReady || done();
                                doneReady = true;
                            } catch(err){
                                clearTimeout(timer);
                                doneReady || done();
                                doneReady = true;
                            }
                        });
                    } catch(err){
                        timer && clearTimeout(timer);
                        doneReady || done();
                        doneReady = true;
                    }
                }
            })(providers[i])));
        }

        window[showadName].waitForMe = Promise.all(list).then(function () {
            delete window[showadName].waitForMe;
        });
    } catch (err) {}

})('__ATA');

// including ad delivery script
(function(g,d,ata,sync){
        var pr="https:"===d.location.protocol?"https:":"http:",src=pr+ata.scriptSrc,st="text/javascript";
        (sync===true)?d.write('<scr'+'ipt type="'+st+'" src="'+src+'"><\/scr'+'ipt>'):inj(src,st);
        function inj(url,st) {
                var s=d.createElement("script"),n=d.getElementsByTagName("script")[0],p=n.parentNode,ib=p.insertBefore;
                s.type=st;s.src=url;s.async=true;(navigator.userAgent.indexOf("Opera")!==-1)?setTimeout(function(){ib.call(p,s,n);},0):ib.call(p,s,n);
        }})(window, window.document, window.__ATA, window.__ATA.isSync);