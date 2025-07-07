document.addEventListener("DOMContentLoaded", function () {
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('animate');
                observer.unobserve(entry.target); // chỉ animate 1 lần
            }
        });
    }, observerOptions);

    document.querySelectorAll('.animate-on-scroll').forEach((el, index) => {
        el.style.transitionDelay = `${index * 0.1}s`; // stagger delay
        observer.observe(el);
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const buttons = document.querySelectorAll(".add-to-cart-btn");
    buttons.forEach(btn => {
        btn.addEventListener("click", function () {
            const id = this.getAttribute("data-id");

            fetch(`/api/cart/add/${id}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
            })
                .then(response => {
                    if (!response.ok) throw new Error("Lỗi thêm vào giỏ hàng");
                    return response.json();
                })
                .then(newCount => {
                    // Cập nhật số lượng trên biểu tượng giỏ hàng
                    document.querySelectorAll(".fa-shopping-cart ~ .badge").forEach(span => {
                        span.textContent = newCount;
                    });
                })
                .catch(error => {
                    alert("Thêm vào giỏ hàng thất bại!");
                    console.error(error);
                });
        });
    });
});
